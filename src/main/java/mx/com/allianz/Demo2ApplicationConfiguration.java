package mx.com.allianz;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@PropertySource("application.properties")
public class Demo2ApplicationConfiguration {

	@Value("${db.server}")
	private String dbServer;

	@Value("${db.port}")
	private int dbPort;

	@Value("${db.username}")
	private String dbUsername;

	@Value("${db.password}")
	private String dbPassword;

	@Value("${db.database}")
	private String dbDatabase;

	@Value("${db.url}")
	private String dbUrl;
	
	@Bean
	public DataSource getOracleDataSource() throws Exception {
		OracleDataSource dataSource = new OracleDataSource();
		
		dataSource.setServerName(dbServer);
		dataSource.setPortNumber(dbPort);
		dataSource.setDatabaseName(dbDatabase);
		dataSource.setUser(dbUsername);
		dataSource.setPassword(dbPassword);
		dataSource.setURL(dbUrl);
		
		return dataSource;
	}
}
