package com.javalec.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.javalec.ex.beans.BoardBean;


public interface TopMenuMapper {

	@Select("select board_idx, board_name " +
			"from board_table " + 
			"order by board_idx")
	List<BoardBean> getTopMenuInfo();
}
