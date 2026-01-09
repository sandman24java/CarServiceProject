package org.example.module3.layered.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix="app")
public class ProfileConfig {
    private String name;
    private String env;
    private boolean showHistory;
    private int maxResults;
}
