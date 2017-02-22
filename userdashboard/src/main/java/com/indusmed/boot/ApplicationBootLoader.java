package com.indusmed.boot;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.indusmed.dao.DashboardServiceDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.indusmed.dao.UserManagementDaoImpl;


@SpringBootApplication(scanBasePackages = "com.indusmed")
public class ApplicationBootLoader {


    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootLoader.class, args);
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/indusmed");
        dataSource.setUsername("root");
        dataSource.setPassword("sandy");
        return dataSource;
    }

    @Bean
    public UserManagementDaoImpl userManagementDao() {
        UserManagementDaoImpl dao = new UserManagementDaoImpl();
        dao.setDataSource(dataSource());
        return dao;
    }

    @Bean
    public DashboardServiceDaoImpl dashboardServiceDao() {
        DashboardServiceDaoImpl dao = new DashboardServiceDaoImpl();
        dao.setDataSource(dataSource());
        return dao;
    }

    @Bean
    public MessageDigest messageDigest() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            return messageDigest;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No such algo");
            return null;
        }
    }
}
