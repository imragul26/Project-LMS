package com.Lms.Config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com" })
@EnableTransactionManagement
public class LmsAnnotationContainer {

	@Bean
	public InternalResourceViewResolver internal() {
		InternalResourceViewResolver in = new InternalResourceViewResolver();
		in.setPrefix("/WEB-INF/view/");
		in.setSuffix(".jsp");

		return in;

	}
    @Bean
	public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {

		LocalSessionFactoryBean local = new LocalSessionFactoryBean();
		local.setDataSource(getDataSource());
		local.setPackagesToScan("com.Lms.Entity");
		local.setHibernateProperties(getHibernateProperties());

		return local;
	}

	private Properties getHibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");

		return properties;
	}
	
	@Bean 
	public DataSource getDataSource() throws PropertyVetoException {	  
		
		 // DriverManagerDataSource dt = new DriverManagerDataSource();
		  
		 // dt.setUrl("jdbc:mysql://127.0.0.1:3306/Lms");
		 // dt.setUsername("root");
		//  dt.setPassword("3306");
		//  dt.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 
		  
		  
		  

			ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setUser("root");
			comboPooledDataSource.setPassword("3306");
			comboPooledDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/Lms");
			comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
			comboPooledDataSource.setInitialPoolSize(10);
			comboPooledDataSource.setAcquireIncrement(5);
			comboPooledDataSource.setMaxIdleTime(3000);
		  
		  return comboPooledDataSource;
		  }
	
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		// transactionManager.setSessionFactory(sessionFactory);

		return transactionManager;

	}
		 
		/*}
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dt = new DriverManagerDataSource();
		// dt.setUrl("jdbc:mysql://127.0.0.1:3306/Lms");
		//dt.setUrl("admin@webapp.cnrmnifpbsbh.us-east-2.rds.amazonaws.com:3306/lms");
		dt.setUrl("jdbc:mysql://webapp.cnrmnifpbsbh.us-east-2.rds.amazonaws.com:3306/?user=admin/lms");
		dt.setUsername("admin");
		dt.setPassword("spiderman2618");
		dt.setDriverClassName("com.mysql.cj.jdbc.Driver");

		return dt;
	}*/

	/*
	 * @Bean public LocalSessionFactoryBean sessionFactory() { //sessionFactory
	 * 
	 * LocalSessionFactoryBean local = new LocalSessionFactoryBean();
	 * 
	 * local.setDataSource(data()); local.setPackagesToScan("com.Lms.Entity");
	 * local.setHibernateProperties(getHibernateProperties());
	 * 
	 * return local; }
	 * 
	 * 
	 * public Properties getHibernateProperties() {
	 * 
	 * Properties pro = new Properties(); pro.put("hibernate.show_sql", "true");
	 * pro.put("hibernate.format_sql", "true"); pro.put("hibernate.dialect",
	 * "org.hibernate.dialect.MySQL55Dialect");
	 * 
	 * return pro; }
	 * 
	 * @Bean public DataSource data() {
	 * 
	 * DriverManagerDataSource dt = new DriverManagerDataSource();
	 * 
	 * dt.setUrl("jdbc:mysql://127.0.0.1:3306/Lms"); dt.setUsername("root");
	 * dt.setPassword("3306"); dt.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 * 
	 * return dt; }
	 */
}
