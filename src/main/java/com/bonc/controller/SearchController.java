package com.bonc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
	@RequestMapping({"","/search"})
	public String search() {
		
		return "search";
	}

	@RequestMapping({"/addInfo"})
	public String addInfo() {
		
		return "addInfo";
	}
	
}
