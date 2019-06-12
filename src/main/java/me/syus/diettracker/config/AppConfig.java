package me.syus.diettracker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "me.syus.diettracker", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "me.syus.diettracker.api.*"))

public class AppConfig {


}
