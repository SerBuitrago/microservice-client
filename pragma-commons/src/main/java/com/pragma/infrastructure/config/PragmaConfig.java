package com.pragma.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Configuration
@ConfigurationProperties("spring.datasource")
@Slf4j
@NoArgsConstructor
@Getter
@Setter
public class PragmaConfig {

}
