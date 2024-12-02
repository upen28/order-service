package com.polarbookshop.orderservice.config;

import java.net.URL;

import org.springframework.boot.context.properties.ConfigurationProperties;

import jakarta.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "polar")
public record ClientProperties(@NotNull URL catalogServiceUri) {
}
