package pl.usa.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan({"pl.usa"})
@PropertySource({ "classpath:db.properties" })
@EnableTransactionManagement
@Import({ SpringSecurity.class })
public class SpringConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment environment;


	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/main/decorators/style/**").addResourceLocations("/WEB-INF/pages/main/decorators/style/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/gamer/decorators/style/**").addResourceLocations("/WEB-INF/pages/gamer/decorators/style/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/org/decorators/style/**").addResourceLocations("/WEB-INF/pages/org/decorators/style/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/org/decorators/js/**").addResourceLocations("/WEB-INF/pages/org/decorators/js/")
				.setCachePeriod(31556926);
	}

	@Bean
	public FreeMarkerViewResolver getFreeMarkerViewResolver() {

		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();

		resolver.setSuffix(".jsp");
		resolver.setCache(true);
		resolver.setContentType("text/html;charset=UTF-8");

		return resolver;
	}

	@Bean
	public FreeMarkerConfigurer getFreeMarkerConfigurer() {

		Properties properties = new Properties();
		properties.setProperty("default_encoding", "UTF-8");

		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setFreemarkerSettings(properties);
		configurer.setTemplateLoaderPath("/WEB-INF/pages/");

		return configurer;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(restDataSource());
		sessionFactory
				.setPackagesToScan(new String[] { "pl.usa.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public DataSource restDataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.user"));
		dataSource.setPassword(environment.getProperty("jdbc.pass"));

		return dataSource;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(
			SessionFactory sessionFactory) {

		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/validation/messages");
		return messageSource;
	}

	Properties hibernateProperties() {

		return new Properties() {
			{
//				setProperty("hibernate.hbm2ddl.auto",
//						environment.getProperty("hibernate.hbm2ddl.auto"));
				setProperty("hibernate.dialect",
						environment.getProperty("hibernate.dialect"));
				//setProperty("hibernate.globally_quoted_identifiers", "true");
			}
		};
	}
}
