package kr.hs.study.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"kr.hs.study.beans","kr.hs.study.dao"})
public class BeanConfigClass {


    //Datasource
    @Bean
    public BasicDataSource source() { // 데이터베이스 접속
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName("oracle.jdbc.OracleDriver");
        source.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        source.setUsername("scott");
        source.setPassword("tiger");

        return source;
    }

    // 데이터베이스에 접속해서 쿼리날림
    @Bean
    public JdbcTemplate db(BasicDataSource source) {
        JdbcTemplate db = new JdbcTemplate(source);
        return db;
    }
}