package com.improve1.pgmtCarShopPr.config;

import com.improve1.pgmtCarShopPr.controller.AppErrorController;
import com.improve1.pgmtCarShopPr.repository.StudentsRepository;
import jakarta.persistence.EntityManagerFactory;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackageClasses= StudentsRepository.class)
@EnableTransactionManagement
public class ProjectConfigM {
    @Autowired
    private ErrorAttributes errorAttributes;

    @Bean
    public AppErrorController appErrorController(){
        return new AppErrorController(errorAttributes);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
//     -   EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//      -  return builder.setType(EmbeddedDatabaseType.HSQL).build();
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//    -    dataSourceBuilder.driverClassName("org.mariadb.jdbc.Driver");
        dataSourceBuilder.type(MariaDbDataSource.class);
//   -     spring.datasource.url=jdbc:mariadb://localhost:3306/pgmt_car_shop_db
//        dataSourceBuilder.url("jdbc:mariadb://localhost:3306/pgmt_car_shop_db");
        dataSourceBuilder.username("root");
        return dataSourceBuilder.build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.improve1.pgmtCarShopPr.model");
        factory.setDataSource(dataSource());
        factory.setEntityManagerFactoryInterface(jakarta.persistence.EntityManagerFactory.class);
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

}
