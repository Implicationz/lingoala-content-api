package com.lingoala.content.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "lingoala.gamification.client")
public class GamificationClientProperties {
    private String apiKey;
    private String url;
}