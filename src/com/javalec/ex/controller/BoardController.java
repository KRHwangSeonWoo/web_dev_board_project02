package com.javalec.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.ex.beans.ContentBean;
import com.javalec.ex.service.BoardService;

@Controller
@PropertySource("/WEB-INF/properties/option.properties")
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/main")
	public String main() {
		return "board/main";
	}

	@GetMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		boardService.getBoardLIst(request, model);
		return "board/list";
	}
	
	@GetMapping("/write")
	public String wirte(@ModelAttribute("contentBean") ContentBean contentBean, 
						@RequestParam("board_idx") int board_idx ) {
		contentBean.setBoard_idx(board_idx);
		return "board/write";
	}
	
	@PostMapping("/write_pro")
	public String write_pro(@Valid @ModelAttribute("contentBean") ContentBean contentBean, BindingResult result,
							Model Model) {
		if(result.hasErrors()) {
			return "board/write";
		}
		boardService.addContentInfo(contentBean, Model);
		return "board/write_success";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request,  @RequestParam("content_idx") int content_idx, @ModelAttribute("contentBean") ContentBean contentBean) {
		boardService.readInfo(request, content_idx, contentBean, 1);
		return "board/read";
	}
	
	@GetMapping("/modify")
	public String modify(HttpServletRequest request,  @RequestParam("content_idx") int content_idx, @ModelAttribute("contentBean") ContentBean contentBean){
		boardService.readInfo(request, content_idx, contentBean, 1);
		return "board/modify";
	}
	
	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("contentBean") ContentBean contentBean, @RequestParam("content_idx") int content_idx, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "board/modify";
		}
		boardService.modifyInfo(contentBean, content_idx, model);
		return "board/modify_success";
	}
	@GetMapping("/not_right")
	public String not_right(@RequestParam("content_idx") int content_idx,Model model) {
		model.addAttribute("content_idx", content_idx);
		return "/board/not_right";
	}
	
}
