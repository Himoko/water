package com.himoko.member.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @description: mybatis配置文件
 * @author: peng.zhang11@ucarinc.com
 * @create: 2019-11-02 10:21
 */
@Component
@Configuration
@EnableConfigurationProperties(value = MySQLPropertise.class)
@MapperScan(basePackages = {"com.himoko.member.dao"})
@RefreshScope
public class MyBatisConfig {

    @Autowired
    private MySQLPropertise mySQLPropertise;

    @Autowired
    private DriverManagerDataSource dataSource;

    @Bean
    @RefreshScope
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(mySQLPropertise.getDriverClassName());
        driverManagerDataSource.setUrl(mySQLPropertise.getUrl());
        driverManagerDataSource.setUsername(mySQLPropertise.getUsername());
        driverManagerDataSource.setPassword(mySQLPropertise.getPassword());
        return driverManagerDataSource;
    }

    @Bean
    @RefreshScope
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath:mapping/*.xml"));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

//    @Bean
//    public PlatformTransactionManager DataTransaction(@Qualifier("localhostDataSource") DataSource localhostDataSource) {
//        return new DataSourceTransactionManager(localhostDataSource);
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(name = "localhostDataSource")
//    public DataSource localhostDataSource() {
//        Properties props = new Properties();
//        props.put("driverClass", mySQLPropertise.getDriverClassName());
//        props.put("url", mySQLPropertise.getUrl());
//        props.put("username", mySQLPropertise.getUsername());
//        props.put("password", mySQLPropertise.getPassword());
//        try {
//            return DruidDataSourceFactory.createDataSource(props);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Bean(name ={"localhostSqlSessionFactory"})
//    public SqlSessionFactory localhostSqlSessionFactory(@Qualifier("localhostDataSource") DataSource localhostDataSource)
//            throws Exception {
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(localhostDataSource);
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis/config/supportingConfig.xml"));
//        sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:mapping/*.xml"));
//        return sqlSessionFactory.getObject();
//    }

}
