package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.configs;

import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.auth.AuditorAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef ="getAuditorAwareImp")
public class ModelMapperConfig
{
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

    @Bean
    public AuditorAware<String> getAuditorAwareImp()
    {
        return new AuditorAwareImpl();
    }

}
