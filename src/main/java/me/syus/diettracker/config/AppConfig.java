package me.syus.diettracker.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import me.syus.diettracker.Service.StorageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "me.syus.diettracker", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "me.syus.diettracker.api.*"))

public class AppConfig {


    @Bean
    public StorageService getStorageServiceBean() {

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        StorageService storageService = new StorageService(s3Client);
        storageService.setBucket("diettracker-dev");
        return storageService;
    }


}
