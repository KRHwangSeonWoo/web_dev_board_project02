package com.javalec.ex.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.javalec.ex.beans.UserBean;
import com.javalec.ex.interceptor.CheckLoginInterceptor;
import com.javalec.ex.interceptor.CheckRightInterceptor;
import com.javalec.ex.interceptor.TopMenuInterceptor;
import com.javalec.ex.mapper.BoardMapper;
import com.javalec.ex.mapper.TopMenuMapper;
import com.javalec.ex.mapper.UserMapper;
import com.javalec.ex.service.TopMenuService;

@Configuration
@EnableWebMvc
@ComponentScan("com.javalec.ex.controller")
@ComponentScan("com.javalec.ex.dao")
@ComponentScan("com.javalec.ex.service")

@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer{
	
	@Value("${db.classname}")
	private String db_classname;
	
	@Value("${db.url}")
	private String db_url;
	
	@Value("${db.username}")
	private String db_username;
	
	@Value("${db.password}")
	private String db_password;
	
	@Autowired
	private TopMenuService topMenuService;
	
	@Resource(name="checkLoginBean")
	private UserBean checkLoginBean;
	

	
	//Controller의 메서드가 반환하는 jsp의 이름 이 뒤에 경로와 확장자를 붙혀주도록 설정한다.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}


	//정적 파일의 경로를 매핑한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/resouces/**").addResourceLocations("/resources/");
	}

	
	//데이터베이스 접속 정보를 관라하는 Bean
	@Bean
	public BasicDataSource dataSource() {
		
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(db_classname);
		source.setUrl(db_url);
		source.setUsername(db_username);
		source.setPassword(db_password);
		
		return source;
	}


	//쿼리문과 접속 정보를 관리하는 객체
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception{
		
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		
		return factory;
	}
	
	
	//Mapper 관리 객체
	@Bean
	public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<UserMapper>(UserMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	@Bean
	public MapperFactoryBean<TopMenuMapper> getTopMenuMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<TopMenuMapper> factoryBean = new MapperFactoryBean<TopMenuMapper>(TopMenuMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	@Bean 
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factroy) throws Exception{
		MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		factoryBean.setSqlSessionFactory(factroy);
		return factoryBean;
	}
	
	//java 방식인 경우  @PropertySource와 ReloadableResourceBundleMessageSource로 메세지를 등록할 경우 두개가 충돌되어 하나도 인식 못함 -> 이를 해결하기 위한 빈
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
	//에러메세지 프로퍼티 연결
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasenames("/WEB-INF/properties/error_messages");
		return res;
	}
	
	
	
	//인터셉터 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
		
		TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(checkLoginBean, topMenuService);
		InterceptorRegistration reg1 = registry.addInterceptor(topMenuInterceptor);
		reg1.addPathPatterns("/**");
	
		CheckLoginInterceptor checkLoginInterceptor = new CheckLoginInterceptor(checkLoginBean);
		InterceptorRegistration reg2 = registry.addInterceptor(checkLoginInterceptor);
		reg2.addPathPatterns("/user/userInfoModify", "/user/logout", "/board/*");
		reg2.excludePathPatterns("/board/main", "/board/list");
		
		CheckRightInterceptor checkRightInterceptor = new CheckRightInterceptor(checkLoginBean);
		InterceptorRegistration reg3= registry.addInterceptor(checkRightInterceptor);
		reg3.addPathPatterns("/board/modify");

	}
	//StandardServletMultipartResolver빈생성 
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	
}
 