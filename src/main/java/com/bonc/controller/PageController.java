package com.bonc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/searchPage")
	public String searchPage() {
		return "html/searchPage";
	}

	@RequestMapping("/addInfoPage")
	public String addInfoPage() {
		return "html/addInfoPage";
	}

	@RequestMapping("/addAndSearch")
	public String addAndSearch() {
		return "html/addAndSearch";
	}
}
