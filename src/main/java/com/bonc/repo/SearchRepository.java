package com.bonc.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.bonc.entity.InfoEntity;

@Repository
public interface SearchRepository extends ElasticsearchRepository<InfoEntity, String>{

}
