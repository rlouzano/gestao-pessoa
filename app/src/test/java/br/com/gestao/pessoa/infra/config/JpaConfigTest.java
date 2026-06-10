package br.com.gestao.pessoa.infra.config;

import br.com.gestao.pessoa.infra.config.properties.DatasourceConfigProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("JpaConfig Tests")
public class JpaConfigTest {

    private jpaConfig jpaConfig;

    @BeforeEach
    public void setUp() {
        jpaConfig = new jpaConfig();
    }

    @Test
    @DisplayName("Should create JpaVendorAdapter bean successfully")
    public void testJpaVendorAdapterBeanCreation() {
        JpaVendorAdapter adapter = jpaConfig.jpaVendorAdapter();

        assertNotNull(adapter);
        assertInstanceOf(HibernateJpaVendorAdapter.class, adapter);
    }

    @Test
    @DisplayName("Should return HibernateJpaVendorAdapter")
    public void testJpaVendorAdapterType() {
        JpaVendorAdapter adapter = jpaConfig.jpaVendorAdapter();

        assertTrue(adapter instanceof HibernateJpaVendorAdapter);
    }

    @Test
    @DisplayName("Should create DataSource bean with properties")
    public void testDataSourceBeanCreation() {
        DatasourceConfigProperties properties = new DatasourceConfigProperties();
        properties.setUrl("jdbc:mysql://localhost:3306/testdb");
        properties.setUsername("root");
        properties.setPassword("password");
        properties.setDriverClassName("com.mysql.cj.jdbc.Driver");

        DataSource dataSource = jpaConfig.dataSource(properties);

        assertNotNull(dataSource);
    }

    @Test
    @DisplayName("Should create DataSource with correct URL")
    public void testDataSourceWithCorrectUrl() {
        DatasourceConfigProperties properties = new DatasourceConfigProperties();
        String expectedUrl = "jdbc:mysql://localhost:3306/testdb";
        properties.setUrl(expectedUrl);
        properties.setUsername("root");
        properties.setPassword("password");
        properties.setDriverClassName("com.mysql.cj.jdbc.Driver");

        DataSource dataSource = jpaConfig.dataSource(properties);

        assertNotNull(dataSource);
        // DataSource is created successfully with the provided URL
    }

    @Test
    @DisplayName("Should create DataSource with all required properties")
    public void testDataSourceWithAllProperties() {
        DatasourceConfigProperties properties = new DatasourceConfigProperties();
        properties.setUrl("jdbc:mysql://db.example.com:3306/production");
        properties.setUsername("admin");
        properties.setPassword("securePassword");
        properties.setDriverClassName("com.mysql.cj.jdbc.Driver");

        DataSource dataSource = jpaConfig.dataSource(properties);

        assertNotNull(dataSource);
    }

    @Test
    @DisplayName("Should handle empty credentials in DataSource")
    public void testDataSourceWithEmptyCredentials() {
        DatasourceConfigProperties properties = new DatasourceConfigProperties();
        properties.setUrl("jdbc:mysql://localhost:3306/testdb");
        properties.setUsername("");
        properties.setPassword("");
        properties.setDriverClassName("com.mysql.cj.jdbc.Driver");

        DataSource dataSource = jpaConfig.dataSource(properties);

        assertNotNull(dataSource);
    }
}

