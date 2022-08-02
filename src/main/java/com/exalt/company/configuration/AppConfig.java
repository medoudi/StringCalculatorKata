package com.exalt.company.configuration;

import com.exalt.company.DelimitterCalculator;
import com.exalt.company.StringCalculatorKata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.exalt.company")
public class AppConfig {

    @Bean
    public DelimitterCalculator delimitterCalculator()
    {
        return new DelimitterCalculator();
    }

    @Bean
    public StringCalculatorKata stringCalculatorKata()
    {
        return new StringCalculatorKata(delimitterCalculator());
    }

}
