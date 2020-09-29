package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.iolist.model.ProductVO;
import com.biz.iolist.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/product")
@Controller
public class ProductController {

	@Autowired
	@Qualifier("proServiceV1")
	ProductService proService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String proHome(Model model) {

		List<ProductVO> proList = proService.selectAll();

		model.addAttribute("PRO_LIST", proList);
		model.addAttribute("BODY", "PRO_HOME");

		return "home";
	}

	// insert GET method : 상품정보 추가 anchor를 클릭했을때
	// write 화면을 보여주기
	// <a href="http://localhost:8080/iolist/product/list"> 상품등록</a> request 반응
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("PRO_VO") ProductVO proVO, Model model) {

		
		model.addAttribute("BODY", "PRO_WRITE");
		
		return "home";
	}
	
	// form에서 값을 입력한 후 저장버튼을 눌렀을 때 호출되는 method
	// <form method="POST">로 되어 있을 때 반응하는 method
		
		@RequestMapping(value = "/insert",method=RequestMethod.POST)
		public String insert(@ModelAttribute ProductVO proVO) {
			
			log.debug("상품정보 입력 : {}", proVO.toString());
			
			int ret = proService.insert(proVO);
			
			return "redirect:/product/";
		}
		
		@RequestMapping(value = "/detail",method=RequestMethod.GET)
		public String detail(@RequestParam("id") String io_pcode, Model model) {
			
			ProductVO proVO = proService.findBySeq(io_pcode);
			
			model.addAttribute("PRO_VO",proVO);
			model.addAttribute("BODY","PRO_DETAIL");
			return "home";
		}
	
	
	

}
