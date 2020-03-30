package com.bonc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bonc.service.SearchService;

@Controller
@RequestMapping("/search")
public class SearchController {
	@Autowired
	SearchService sService;
	
	@RequestMapping({"","/search"})
	@ResponseBody
	public String search(String cond) {
		String result = sService.searchInfo(cond);
		return result;
	}

	@RequestMapping({"/addInfo"})
	public String addInfo(String info) {
		sService.addInfo(info);
		return "html/searchPage";
	}
	
}
