package com.javalec.ex.mapper; 

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.javalec.ex.beans.ContentBean;

public interface BoardMapper {
	
	@Select("select writer_idx, writer_id, title, to_char(content_date, 'YYYY-MM-DD') as content_date, content_idx, content_body, content_file "+
			"from content_table "+
			"where board_idx=#{board_idx}")
	public List<ContentBean> getBoardList(int board_idx);
	

	@Insert("insert into content_table(writer_id, writer_idx, title, content_idx, content_body, content_file, board_idx) "+
			"values( #{writer_id},#{writer_idx}, #{title}, board_content_seq.nextval, #{content_body}, #{content_file, jdbcType=VARCHAR}, #{board_idx})")
	public void addContentInfo(ContentBean contentBean);

	@Select("select title, content_body, content_file, writer_id, writer_idx, content_idx, board_idx "+
			"from content_table "+ 
			"where content_idx=#{content_idx}")
	public ContentBean readInfo(int content_idx);

	@Update("update content_table set title=#{title}, content_body=#{content_body},content_file= #{content_file, jdbcType=VARCHAR} "+
			"where content_idx=#{content_idx}")
	public void modifyInfo(ContentBean contentBean);
	
	@Delete("delete content_table where content_idx=#{content_idx}")
	public void delete(int content_idx);

}
