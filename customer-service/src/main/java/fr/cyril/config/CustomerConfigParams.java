package fr.cyril.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

// First Way
@ConfigurationProperties(prefix = "customer.params")
public record CustomerConfigParams(int x, int y) {

}
