package com.lingoala.content.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "lingoala.content")
public class ContentProperties {
    private List<String> languages;
}