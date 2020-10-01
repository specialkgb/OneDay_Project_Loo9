package com.biz.iolist.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.iolist.model.ProductVO;
import com.biz.iolist.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/")
@Controller
public class ProductController {

	@Autowired
	@Qualifier("proServiceV1")
	private ProductService proService;
	
	@Transactional
	
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String proHome(Model model) {

		List<ProductVO> proList = proService.selectAll();
		log.debug(proList.toString());
		model.addAttribute("PRO_LIST", proList);
		model.addAttribute("BODY", "PRO_HOME");
		
		return "home";
	}


	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("PRO_VO") ProductVO proVO, Model model) {

		model.addAttribute("URL", "/insert");
		model.addAttribute("BODY", "PRO_INSERT");
		return "home";
	}
	
	
		
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("proVO") ProductVO proVO) {
			
		LocalDateTime localDateTime = LocalDateTime.now();
        String Date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDateTime);
        String Time = DateTimeFormatter.ofPattern("HH:mm:ss").format(localDateTime);

        proVO.setIo_date(Date);
        proVO.setIo_time(Time);
        proService.insert(proVO);
		return "redirect:/";
	}
	
	
	
	@RequestMapping(value = "/detail",method=RequestMethod.GET)
	public String detail(@RequestParam("seq") String seq, Model model) {
			
		ProductVO proVO = proService.findBySeq(Long.parseLong(seq));
		log.debug(seq);
		
		model.addAttribute("ProductVO",proVO);
		model.addAttribute("BODY","PRO_DETAIL");
		return "home";
	}
	
	
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("seq") String seq) {
        proService.delete(Long.parseLong(seq));
        return "redirect:/";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(@RequestParam("seq") String seq, Model model) {
    	
    	ProductVO proVO = proService.findBySeq(Long.parseLong(seq));
        
        model.addAttribute("ProductVO", proVO);
        model.addAttribute("BODY", "PRO_INSERT");
        model.addAttribute("URL", "/update");
        return "home";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute ProductVO proVO, Model model) {
    	
        
        int ret = proService.update(proVO);
        
        model.addAttribute("seq", proVO.getIo_seq());
        return "redirect:/";
    }
    
}
