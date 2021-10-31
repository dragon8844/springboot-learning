package com.dragon.elasticsearch.repository;

import com.dragon.elasticsearch.dataobject.ESProductDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author lilong
 */
public interface ProductRepository extends ElasticsearchRepository<ESProductDO, Integer> {

}
