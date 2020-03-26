package com.pyf.house.service;

import cn.hutool.core.map.MapUtil;
import com.pyf.house.util.BeanUtil;
import com.pyf.house.util.EsUtil;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class EsServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean create(String indexName, String typeName, Object obj) throws IOException {
        Map<String, Object> objMap = BeanUtil.beanToMap(obj);
        IndexRequest indexRequest = new IndexRequest(indexName, typeName, objMap.get("id").toString()).source(objMap);
        RestHighLevelClient restHighLevelClient = EsUtil.restClient();
        IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        logger.info("create response: {} ", response.toString());
        restHighLevelClient.close();
        return true;
    }


    public boolean isExist(String indexName, String typeName, String docId) throws IOException {
        GetRequest getRequest = new GetRequest(indexName,typeName,docId);
        RestHighLevelClient restHighLevelClient = EsUtil.restClient();
        GetResponse response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        logger.info("isExist response: {} ", response.toString());
        restHighLevelClient.close();
        if (response.isExists()) {
            return true;
        }else{
            return false;
        }
    }



}
