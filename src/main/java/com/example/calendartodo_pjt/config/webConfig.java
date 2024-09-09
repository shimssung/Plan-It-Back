package com.example.calendartodo_pjt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 환경설정을 위한 어노테이션 - Configuration
@Configuration
public class webConfig implements WebMvcConfigurer{
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 사용하는 URL모든것들에 적용
       registry.addMapping("/**")
                // 리액트에서 치고들어오는걸 허용한다는 뜻
                // 해당 서버에있는 자원을 공유한다는 뜻
                // 리액트에서 GET으로 접근하는 경우 허용
                // GET대신 POST방식으로 바꾸면 403에서 발생
                // GET과 POST둘다 쓰고싶으면 *사용
               .allowedOrigins("http://localhost:3001")
               .allowedMethods("*");
    }
}
