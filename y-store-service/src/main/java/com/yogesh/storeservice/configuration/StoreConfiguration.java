package com.yogesh.storeservice.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.yogesh.storeservice.dao.store", entityManagerFactoryRef = "storeEntityManagerFactory", transactionManagerRef = "storeTransactionManager")
@EnableTransactionManagement
public class StoreConfiguration {

	@Primary
	@Bean(name = "store")
	@ConfigurationProperties(prefix = "store.datasource")
	public DataSource storeDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "storeEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean storeEntityManagerFactory(final EntityManagerFactoryBuilder builder,
			final @Qualifier("store") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.yogesh.storeservice.model.store").persistenceUnit("store")
				.build();
	}

	@Primary
	@Bean(name = "storeTransactionManager")
	PlatformTransactionManager storeTransactionManager(
			@Qualifier("storeEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
