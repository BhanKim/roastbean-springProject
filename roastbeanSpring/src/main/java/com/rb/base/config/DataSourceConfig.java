
/*
 DB사용을 위한 설정 파일로 application.properties에 선언 spring.datasource.* 값들로 DataSource를 빌드한다.
 DB연동은 다른 방법으로 가능하지만 보다 유지 보수를 위해 클래스 파일로 분리하는 작업.
 */


package com.rb.base.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	@ConfigurationProperties(prefix = "rb.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
