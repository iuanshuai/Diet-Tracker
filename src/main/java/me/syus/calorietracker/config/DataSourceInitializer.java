package me.syus.calorietracker.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
@Configuration

public class DataSourceInitializer {
    protected String databaseUrl = "jdbc:postgresql://localhost:5432/calorietracker";
    protected String databaseUserName = "admin";
    protected String databasePassword = "password";
    protected String driverClassName="org.postgresql.ds.PGSimpleDataSource";


    @Bean(name = "dataSource")

    public DataSource getDataSource() {
        DataSource dataSource = createDataSource();
        return dataSource;
    }

    private BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
        dataSource.setNumTestsPerEvictionRun(3);
        dataSource.setMinEvictableIdleTimeMillis(1800000);
        return dataSource;
    }
}

