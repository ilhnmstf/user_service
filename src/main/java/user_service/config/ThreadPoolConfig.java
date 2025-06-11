package user_service.config;

import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolConfig {

    @Bean
    public ExecutorService saveUserPool() {
        return Executors.newFixedThreadPool(10);
    }
}
