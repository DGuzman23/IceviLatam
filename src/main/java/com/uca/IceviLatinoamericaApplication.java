package com.uca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.uca.controller.MainController;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.io.File;

@SpringBootApplication
public class IceviLatinoamericaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(IceviLatinoamericaApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(IceviLatinoamericaApplication.class);
    }

}
