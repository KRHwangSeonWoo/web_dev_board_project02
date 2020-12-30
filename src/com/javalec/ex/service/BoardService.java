package com.javalec.ex.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.javalec.ex.beans.ContentBean;
import com.javalec.ex.beans.UserBean;
import com.javalec.ex.dao.BoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {
	
	@Value("${path.upload}")
	private String path_upload;
	
	@Autowired
	private BoardDao boardDao;
	
	@Resource(name="checkLoginBean")
	private UserBean checkLoginBean;
	
	private String uploadFile(MultipartFile file) {
		String file_name = checkLoginBean.getUser_id()+"-"+System.currentTimeMillis();
		try {
			file.transferTo(new File(path_upload + "/" + file_name));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return file_name;
	}
	
	
public void addContentInfo(ContentBean contentBean, Model model) {
		
		MultipartFile upload_file = contentBean.getUpload_file();
		
		
		if(upload_file.getSize() > 0) {
			String file_name = uploadFile(upload_file);
			contentBean.setContent_file(file_name);
		}
		
		contentBean.setWriter_idx(checkLoginBean.getUser_idx());
		contentBean.setWriter_id(checkLoginBean.getUser_id());
		model.addAttribute("board_idx", contentBean.getBoard_idx());
		boardDao.addContentInfo(contentBean);

}
	

		public void getBoardLIst(HttpServletRequest request, Model model){
		int board_idx=Integer.parseInt((String) request.getParameter("board_idx"));
		model.addAttribute("list_info",boardDao.getBoardList(board_idx));
		model.addAttribute("board_idx", board_idx);
	}
		
		
		public void readInfo(HttpServletRequest request, int content_idx, ContentBean contentBean) {
			
			request.setAttribute("path_upload", path_upload);
			ContentBean tempContentBean=boardDao.readInfo(content_idx);	
			contentBean.setContent_idx(tempContentBean.getContent_idx());
			contentBean.setWriter_idx(tempContentBean.getWriter_idx());
			contentBean.setWriter_id(tempContentBean.getWriter_id());
			contentBean.setTitle(tempContentBean.getTitle());
			contentBean.setContent_body(tempContentBean.getContent_body());
			contentBean.setContent_file(tempContentBean.getContent_file());
			contentBean.setBoard_idx(tempContentBean.getBoard_idx());
			System.out.println(contentBean.getBoard_idx());
		}

		public void modifyInfo(HttpServletRequest request,ContentBean contentBean, int content_idx, Model model) {
			
			MultipartFile upload_file = contentBean.getUpload_file();
			ContentBean tempContentBean=new ContentBean();
			readInfo(request, content_idx, tempContentBean);
			if(upload_file.getSize() > 0) {
				String file_name = uploadFile(upload_file);
				contentBean.setContent_file(file_name);
			}else if(upload_file.getSize() == 0) {
				contentBean.setContent_file(tempContentBean.getContent_file());
			}
			model.addAttribute("board_idx", tempContentBean.getBoard_idx());
			contentBean.setContent_idx(content_idx);
			boardDao.modifyInfo(contentBean);
		}


		public void delete(HttpServletRequest request, Model model) {
			
			int content_idx=Integer.parseInt(request.getParameter("content_idx"));
			ContentBean tempContentBean=new ContentBean();
			readInfo(request, content_idx, tempContentBean);
			model.addAttribute("board_idx", tempContentBean.getBoard_idx());
			boardDao.delete(content_idx);
		}
	
}
