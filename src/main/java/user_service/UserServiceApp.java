package user_service;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class UserServiceApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(UserServiceApp.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
