package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class ModelMapperConfig
{
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

}
