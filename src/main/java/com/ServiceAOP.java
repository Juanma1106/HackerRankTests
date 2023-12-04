package com;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

interface ServiceCallback {

	public void callback(String methodName);
}

interface SearchCallback {

	public void callback(String searchedBook);
}

interface RepositoryCallback {

	public void callback();
}

@Aspect
public class ServiceAOP {

	@Autowired
	ServiceCallback serviceCallback;
	@Autowired
	SearchCallback searchCallback;
	@Autowired
	RepositoryCallback repositoryCallback;

	public void serviceAdvice(JoinPoint jp) {
		serviceCallback.callback(jp.getSignature().getName());
	}

	public void repositoryAdvice(JoinPoint jp) {
		repositoryCallback.callback();
	}

	public void searchServiceAdvice(JoinPoint joinPoint) throws Throwable {
		searchCallback.callback((String) joinPoint.getArgs()[0]);
	}
}

@Configuration
@EnableAspectJAutoProxy
@Import(ServiceAOP.class)
@ComponentScan(basePackages = "com.testdome.service")
class Config {

	@Bean
	public ServiceCallback serviceCallback() {
		return (methodName) -> System.out.println(methodName);
	}

	@Bean
	public SearchCallback searchCallback() {
		return (book) -> System.out.println(book);
	}

	@Bean
	public RepositoryCallback repositoryCallback() {
		return () -> System.out.println("Repository called!");
	}
}