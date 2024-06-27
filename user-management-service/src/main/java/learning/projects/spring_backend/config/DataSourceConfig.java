package learning.projects.spring_backend.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
	@Value("${datasource.url}")
	private String jdbcUrl;
	@Value("${datasource.username}")
	private String username;
	@Value("${datasource.credential}")
	private String password;
	@Value("${datasource.connectiontimeout}")
	private long connectionTimeout;
	@Value("${datasource.driverclassname}")
	private String driverClassName;
	@Value("${datasource.maxpoolsize}")
	private int maxPoolSize;
	@Value("${datasource.schema}")
	private String schema;
	
	@Bean
	public DataSource createDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(jdbcUrl);
		config.setUsername(username);
		config.setPassword(password);
		config.setConnectionTimeout(connectionTimeout);
		config.setDriverClassName(driverClassName);
		config.setMaximumPoolSize(maxPoolSize);
		config.setSchema(schema);
		return new HikariDataSource(config);		
	}

}
