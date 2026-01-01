package com.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class MovieLogAspect {

	@Before("execution(* com.Service.MovieServiceImpl.saveMovie(..))")
	public void beforeSavedMovieLog() {
		log.info("Entered into saveMovie() Method...");

	}

	@After("execution(* com.Service.MovieServiceImpl.saveMovie(..))")
	public void afterSavedMovieLog() {
		log.info("Saved Successfully into the database!!");

	}

	@Around("execution(* com.Service.MovieServiceImpl.fetchMovie(..))") /// used for before+ after the method After+
																		/// Before the method
	public Object logEntryAndExit(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("Starting method: {}", joinPoint.getSignature().getName());

		Object result = joinPoint.proceed();
		log.info("Completed method: {}", joinPoint.getSignature().getName());
		return result;

	}

	@AfterThrowing("execution(* com.Service.MovieServiceImpl.*(..))")
	public void movieNotFoundLog() {
		log.error("Movie Not found in the database!...");

	}

	@AfterReturning("execution(* com.Service.MovieServiceImpl.*(..))")
	public void getMovieSuccessfullyExit() {
		log.error("Returning from succesfully methods...");

	}

}
