package ru.grechishkin.spring3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class Config {

    public static void main(String[] args) {
        SpringApplication.run(Config.class, args);
    }

    @Bean
    public FilterRegistrationBean hiddenHttpMethodFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new HiddenHttpMethodFilter());
        return filterRegistrationBean;
    }
}
