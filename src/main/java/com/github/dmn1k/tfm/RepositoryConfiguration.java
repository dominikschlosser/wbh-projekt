package com.github.dmn1k.tfm;

import com.github.dmn1k.tfm.inserate.Inserat;
import com.github.dmn1k.tfm.stories.Story;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Inserat.class);
        config.exposeIdsFor(Story.class);
    }
}
