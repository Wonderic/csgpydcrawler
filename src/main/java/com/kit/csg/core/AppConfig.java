package com.kit.csg.core;

import com.alibaba.druid.pool.DruidDataSource;
import com.kit.csg.crawler.typhoon.config.TyphoonConfig;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootConfiguration
@ComponentScan
@EnableTransactionManagement
@EnableJpaRepositories
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig
{
    @Autowired
    private Environment env;

    @Value("${init-db:false}")
    private String initDatabase;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name="jdbcTemplate")
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public DataSource dataSource()
    {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setDefaultAutoCommit(true);
        return dataSource;
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource)
    {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("data.sql"));
        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
        return dataSourceInitializer;
    }

    @Bean
    public JobFactory jobFactory(){
        return new SpringBeanJobFactory();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(jobFactory);
        return schedulerFactoryBean;
    }

    @Bean(name="typhoonConfig")
    public TyphoonConfig typhoonConfig(){
        TyphoonConfig typhoonConfig = new TyphoonConfig();
        typhoonConfig.setZjwaterBase(env.getProperty("typhoon.source.zjwater.base"));
        typhoonConfig.setZjwatertyphoonInfo(env.getProperty("typhoon.source.zjwater.typhoonInfo"));
        typhoonConfig.setZjwatertyphoonList(env.getProperty("typhoon.source.zjwater.typhoonList"));
        typhoonConfig.setZjwatertyhoonActivity(env.getProperty("typhoon.source.zjwater.tyhoonActivity"));

        typhoonConfig.setJpdigitalTyphoonInfo(env.getProperty("typhoon.routes.jpdigital.typhoonInfo"));
        typhoonConfig.setJpdigitalTyphoonList(env.getProperty("typhoon.source.jpdigital.typhoonList"));
        return typhoonConfig;
    }

}