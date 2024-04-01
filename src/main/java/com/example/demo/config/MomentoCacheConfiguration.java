package com.example.demo.config;

import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.config.AbstractSSMConfiguration;
import com.google.code.ssm.providers.momento.MomentoAddressProvider;
import com.google.code.ssm.providers.momento.MomentoCacheClientFactory;
import com.google.code.ssm.providers.momento.MomentoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MomentoCacheConfiguration extends AbstractSSMConfiguration {

    @Bean
    @Override
    public CacheFactory defaultMemcachedClient() {
        final MomentoConfiguration conf = new MomentoConfiguration();
        conf.setConsistentHashing(true);
        conf.setDefaultTtl(300);
        conf.setCacheName("test");
        conf.setMomentoAuthToken(System.getenv("MOMENTO_AUTH_TOKEN"));
        final CacheFactory cacheFactory = new CacheFactory();
        cacheFactory.setCacheClientFactory(new MomentoCacheClientFactory());
        // Use a MomentoAddressProvider to be explicit
        cacheFactory.setAddressProvider(new MomentoAddressProvider());
        cacheFactory.setConfiguration(conf);
        return cacheFactory;
    }
}
