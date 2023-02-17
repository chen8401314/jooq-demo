package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.TransactionProvider;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@Slf4j
public class JooqConfiguration {

    /**
     * 创建DSL的上下文，
     * DSLContext可以去拼接sql信息。
     */
    @Bean
    public DSLContext dslContext(org.jooq.Configuration configuration) {
        return DSL.using(configuration);
    }


    /*******************************************************************
     * 主库的配置
     *******************************************************************/

    /**
     * 定义数据源
     */
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }


    /**
     * 主库的配置
     */
    @Bean
    @Primary
    public org.jooq.Configuration configuration() {
        //配置信息
        org.jooq.Configuration configuration = new DefaultConfiguration();
        //配置信息
        configuration.set(SQLDialect.MYSQL).settings()
                .withRenderFormatted(true)
                .withRenderCatalog(false)
                .withRenderSchema(false);
        //数据源，填充durid数据源
        configuration.set(dataSourceConnectionProvider());
        configuration.set(transactionProvider());
        return configuration;
    }

    /**
     * 事务管理器
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * 数据源连接的代理
     */
    @Bean
    public DataSourceConnectionProvider dataSourceConnectionProvider() {
        return new DataSourceConnectionProvider(
                new TransactionAwareDataSourceProxy(dataSource()));
    }

    /**
     * 事务提供者
     */
    @Bean
    public TransactionProvider transactionProvider() {
        return new SpringTransactionProvider(transactionManager());
    }
}
