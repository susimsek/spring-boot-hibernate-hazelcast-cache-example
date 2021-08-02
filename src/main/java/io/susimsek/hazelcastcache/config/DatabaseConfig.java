package io.susimsek.hazelcastcache.config;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Configuration
@EnableJpaRepositories("io.susimsek.hazelcastcache.repository")
@EnableJpaAuditing
@EnableTransactionManagement
public class DatabaseConfig {


}
