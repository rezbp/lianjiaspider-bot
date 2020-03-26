package com.pyf.house.util;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class EsUtil {

    public static RestHighLevelClient restClient() {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost("134.175.81.50", 9200, "http")));
        return restHighLevelClient;
    }

    public static void closeClient(RestHighLevelClient restHighLevelClient) throws IOException {
        restHighLevelClient.close();
    }


}
