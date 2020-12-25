package com.javalec.ex.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.javalec.ex.beans.BoardBean;
import com.javalec.ex.dao.TopMenuDao;

@Service
public class TopMenuService {

	@Autowired
	private TopMenuDao topMenuDao;
	
	public List<BoardBean> getTopMenuInfo(){
		List<BoardBean> topMenuList= topMenuDao.getTopMenuInfo();
		return topMenuList;
	}
}
