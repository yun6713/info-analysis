package com.bonc.service.impl;

import java.util.Collections;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonc.repo.SearchRepository;
import com.bonc.service.SearchService;
@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	SearchRepository esRepo;

	@Override
	public String addInfo(String origin) {
		esRepo.saveAll(Collections.EMPTY_LIST);
		return "ok";
	}

	@Override
	public String searchInfo(String cond) {
		QueryBuilder builder = QueryBuilders.matchQuery("info", cond);
		esRepo.search(builder);
		return null;
	}
	
}
