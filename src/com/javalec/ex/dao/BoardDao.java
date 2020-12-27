package com.javalec.ex.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javalec.ex.beans.BoardBean;
import com.javalec.ex.beans.ContentBean;
import com.javalec.ex.mapper.BoardMapper;

@Repository
public class BoardDao {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<ContentBean> getBoardList(int board_idx){
		List<ContentBean> boardList= boardMapper.getBoardList(board_idx);
		return boardList;
	}

	public void addContentInfo(ContentBean contentBean) {
		// TODO Auto-generated method stub
		boardMapper.addContentInfo(contentBean);

	}

	public ContentBean readInfo(int content_idx) {
		// TODO Auto-generated method stub
		return boardMapper.readInfo(content_idx);
	}

	public void modifyInfo(ContentBean contentBean) {
		// TODO Auto-generated method stub
		boardMapper.modifyInfo(contentBean);
	}
}
