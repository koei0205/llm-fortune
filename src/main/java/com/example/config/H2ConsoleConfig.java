package com.example.llmfortune.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 明示的に H2 Console のサーブレットを登録し、/h2-console/* でアクセスできるようにする。
 * Spring Boot の自動設定が何らかの理由で効かない環境でも確実にコンソールが有効化される。
 */
@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean<WebServlet> h2ConsoleServlet() {
        ServletRegistrationBean<WebServlet> registration = new ServletRegistrationBean<>(new WebServlet(), "/h2-console/*");
        registration.setLoadOnStartup(1);
        return registration;
    }
}
