package com.bonc.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.bonc.entity.InfoEntity;
import com.bonc.repo.SearchRepository;
import com.bonc.service.SearchService;
@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	SearchRepository esRepo;
	public static final String SEP_STR=Pattern.quote("白茶小助手(2077734456)");
	public static final Pattern PATTERN = Pattern.compile(SEP_STR);
	@Override
	public String addInfo(String origin) {
		if(StringUtils.hasText(origin)) {
			String[] infos = PATTERN.split(origin);
			List<InfoEntity> list=Arrays.stream(infos)
					.filter(item->Objects.nonNull(item)&&item.length()>10)
					.map(InfoEntity::new)
					.collect(Collectors.toList());
			//新增前删除，避免重复
			esRepo.deleteAll();
			esRepo.saveAll(list);
		}
		return "ok";
	}   

	@Override
	public String searchInfo(String cond) {
		QueryBuilder builder = QueryBuilders.matchQuery("info", cond);
		Iterable<InfoEntity> its=esRepo.search(builder);
		List<InfoEntity> list = new ArrayList<>();
		its.forEach(list::add);
		return JSON.toJSONString(list);
	}
	
}
