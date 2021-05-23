package com.eden.shop.search.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * ElasticsearchConfig
 *
 * @author nvhien
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.eden.shop.search.repository")
@ComponentScan(basePackages = "com.eden.shop.search")
public class ElasticsearchConfig {

    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.port}")
    private Integer port;
    @Value("${elasticsearch.key}")
    private String key;
    @Value("${elasticsearch.secret}")
    private String secret;

    @Bean
    @SuppressWarnings("java:S2095")
    public RestHighLevelClient client() {

        var clientConfiguration = ClientConfiguration.builder()
                .connectedTo("%s:%d".formatted(host, port))
                .usingSsl()
                .withBasicAuth(key, secret)
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {

        return new ElasticsearchRestTemplate(client());
    }
}
