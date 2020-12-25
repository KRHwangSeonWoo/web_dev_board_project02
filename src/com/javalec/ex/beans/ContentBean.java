package com.javalec.ex.beans;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public class ContentBean {
	@NotBlank
	private String  title;
	@NotBlank
	private String content_body;
	private String  content_file;
	private	int content_idx;
	private	String writer_id;
	private int  writer_idx;   
    private int board_idx;
    private String content_date;
	private MultipartFile upload_file;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent_body() {
		return content_body;
	}
	public void setContent_body(String content_body) {
		this.content_body = content_body;
	}
	public String getContent_file() {
		return content_file;
	}
	public void setContent_file(String content_file) {
		this.content_file = content_file;
	}
	public int getContent_idx() {
		return content_idx;
	}
	public void setContent_idx(int content_idx) {
		this.content_idx = content_idx;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public int getWriter_idx() {
		return writer_idx;
	}
	public void setWriter_idx(int writer_idx) {
		this.writer_idx = writer_idx;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getContent_date() {
		return content_date;
	}
	public void setContent_date(String content_date) {
		this.content_date = content_date;
	}
	public MultipartFile getUpload_file() {
		return upload_file;
	}
	public void setUpload_file(MultipartFile upload_file) {
		this.upload_file = upload_file;
	}

   
   
   
}



