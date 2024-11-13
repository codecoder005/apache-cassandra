package com.popcorn.config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;

@Configuration
public class AppConfigBeans {
    @Bean
    public Gson jsonHelper() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.setPrettyPrinting().create();
    }
    @Bean
    public CassandraTemplate cassandraTemplate(CqlSession session, CassandraConverter converter) {
        return new CassandraTemplate(session, converter);
    }
}
