package com.ibase.mall.web.init;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.ibase.mall.web.dao"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {
	@Bean(name="demo")
	@ConfigurationProperties(prefix = "spring.datasource.druid.cart")
	public DataSource dataSourceFavorite(){
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSourceFavorite());
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
		factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml"));
		factoryBean.setVfs(SpringBootVFS.class);
		factoryBean.setTypeAliasesPackage("com.ibase.mall.web.entity");
		return factoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate getFavSqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory());
		return template;
	}
}
