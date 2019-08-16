package io.github.aleknik.streetcamloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StreetCamLoaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreetCamLoaderApplication.class, args);
    }

}
