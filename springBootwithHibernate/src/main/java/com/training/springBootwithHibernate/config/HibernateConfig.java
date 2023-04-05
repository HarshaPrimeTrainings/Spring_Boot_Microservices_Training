package com.training.springBootwithHibernate.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {

	@Bean
	public SessionFactory initSessionfactory() {
		org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		return sf;
	}

}
