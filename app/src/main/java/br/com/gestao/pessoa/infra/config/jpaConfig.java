package br.com.gestao.pessoa.infra.config;

import br.com.gestao.pessoa.infra.config.properties.DatasourceConfigProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "br.com.gestao.pessoa.infra.repository")
public class jpaConfig {

    @Bean
    JpaVendorAdapter jpaVendorAdapter () {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    DataSource dataSource(DatasourceConfigProperties datasourceConfigProperties) {
        return DataSourceBuilder.create()
                .url(datasourceConfigProperties.getUrl())
                .username(datasourceConfigProperties.getUsername())
                .password(datasourceConfigProperties.getPassword())
                .driverClassName(datasourceConfigProperties.getDriverClassName())
                .build();
    }
}
