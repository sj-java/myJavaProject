package com.haoyun.personnelProject.config;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.haoyun.personnelProject.util.XulUtils;
import org.aopalliance.intercept.Interceptor;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

@Configuration
@EnableTransactionManagement
public class DruidConfig implements EnvironmentAware {

    private static final Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource druidDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        try {
            datasource.setUrl(environment.getProperty("spring.datasource.url"));
            datasource.setUsername(environment.getProperty("spring.datasource.username"));
            datasource.setPassword(environment.getProperty("spring.datasource.password"));
            datasource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
            datasource.setInitialSize(XulUtils.tryParseInt(environment.getProperty("spring.datasource.initialSize")));
            datasource.setMinIdle(XulUtils.tryParseInt(environment.getProperty("spring.datasource.minIdle")));
            datasource.setMaxActive(XulUtils.tryParseInt(environment.getProperty("spring.datasource.maxActive"),20));
            datasource.setMaxWait(XulUtils.tryParseInt(environment.getProperty("spring.datasource.maxWait")));
            datasource.setTimeBetweenEvictionRunsMillis(XulUtils.tryParseInt(environment.getProperty("spring.datasource.timeBetweenEvictionRunsMillis")));
            datasource.setMinEvictableIdleTimeMillis(XulUtils.tryParseInt(environment.getProperty("spring.datasource.minEvictableIdleTimeMillis")));
            datasource.setValidationQuery(environment.getProperty("spring.datasource.validationQuery"));
            datasource.setTestWhileIdle(Boolean.getBoolean(environment.getProperty("spring.datasource.testWhileIdle")));
            datasource.setTestOnBorrow(Boolean.getBoolean(environment.getProperty("spring.datasource.testOnBorrow")));
            datasource.setTestOnReturn(Boolean.getBoolean(environment.getProperty("spring.datasource.testOnReturn")));

            datasource.setFilters(environment.getProperty("spring.datasource.filters"));
            logger.info("DuridConfig-----数据源完成");
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }

        return datasource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource());
        //mybayis分页插件
		/*PageHelper pageHelper=new PageHelper();
		Properties props=new Properties();
		props.setProperty("dialect", "mysql");
        props.setProperty("reasonable", "true");
        props.setProperty("supportMethodsArguments", "true");
        props.setProperty("returnPageInfo", "check");
        props.setProperty("params", "count=countSql");
        pageHelper.setProperties(props);
        sqlSessionFactoryBean.setPlugins((org.apache.ibatis.plugin.Interceptor[]) new Interceptor[]{(Interceptor) pageHelper});*/
        //添加XML目录
        VFS.addImplClass(SpringBootVFS.class);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/com/haoyun/personnelProject/mapper/*.xml"));
            logger.info("dao层扫描包为:classpath:/com/haoyun/personnelProject/mapper/*.xml");
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            logger.info("classpath:/com/haoyun/personnelProject/mapper/*.xml路径未找到");
            e.printStackTrace();
        }
        return null;
    }
    //开启事务管理器
	/*@Bean
	public PlatformTransactionManager transactionManager() throws SQLException {
	        return new DataSourceTransactionManager(druidDataSource());
	 
	}*/

}
