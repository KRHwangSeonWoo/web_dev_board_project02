package com.javalec.ex.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javalec.ex.beans.BoardBean;
import com.javalec.ex.mapper.BoardMapper;
import com.javalec.ex.mapper.TopMenuMapper;

@Repository
public class TopMenuDao {

	@Autowired
	private TopMenuMapper topMenuMapper;
	
	public List<BoardBean> getTopMenuInfo() {
		List<BoardBean> topMenuList= topMenuMapper.getTopMenuInfo();
		return topMenuList;
	}
	

	
}
