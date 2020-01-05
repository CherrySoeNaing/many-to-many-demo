package com.solt.demo.manytomanydemo;

import com.solt.demo.manytomanydemo.service.IDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManyToManyDemoApplication {

    public ManyToManyDemoApplication(IDatabase iDatabase) {
        this.iDatabase = iDatabase;
    }

    private final IDatabase iDatabase;


    public static void main(String[] args) {
        SpringApplication.run(ManyToManyDemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner runner(){
        return args -> {
            iDatabase.createTable();

        };
    }

}
