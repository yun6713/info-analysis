package com.bonc;

import java.util.regex.Pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.bonc.repo.EsRepositoryMarker;
/**
 * 信息检索，信息存入es；检索信息按空格分隔。
 * html显示；
 * @author litianlin
 * @date   2020年3月27日下午4:31:11
 * @Description TODO
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackageClasses= {EsRepositoryMarker.class})
public class InfoAnalysisApplication {
	public static final String SEARCH = "";
	public static final String SEP_STR = Pattern.quote("白茶小助手 ");
	public static void main(String[] args) {
		SpringApplication.run(InfoAnalysisApplication.class, args);
	}

}
