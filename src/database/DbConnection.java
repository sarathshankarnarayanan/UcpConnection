package database;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Dao.StudentDaoImplementation;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class DbConnection {
	
	
	private static final Logger logger = LoggerFactory.getLogger(DbConnection.class);
	private static PoolDataSource poolDataSource = PoolDataSourceFactory.getPoolDataSource();
	
	
	static{
		
			try {
					poolDataSource.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
					poolDataSource.setURL("jdbc:oracle:thin:@localhost:1521/orcl");
					poolDataSource.setUser("system");
					poolDataSource.setPassword("root");
					poolDataSource.setInitialPoolSize(5);
					poolDataSource.setMaxPoolSize(10);
			
				}catch(Exception e)
				{
						System.out.println("Error : " +e );
						logger.error(e.getMessage());
			
				}
		}
	
	public static DataSource getPoolDataSource() {
		
		
		return poolDataSource;
		
	}
}
