package com.mastering.spring.context;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = { "com.mastering.spring" })
class PrimaryAnnotationSpringContext {

}

interface SortingAlgorithm {

}

@Component
@Qualifier("mergesort")
class MergeSort implements SortingAlgorithm {
  // Class code here
}

@Component
@Primary
class QuickSort implements SortingAlgorithm {
  // Class code here
}

@Component
class SomeService {
  @Autowired
  @Qualifier("mergesort")
  SortingAlgorithm algorithm;
}

public class PrimaryAnnotationJavaContext {

  public static Logger logger = Logger
      .getLogger(PrimaryAnnotationJavaContext.class);

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
        PrimaryAnnotationSpringContext.class);

    SortingAlgorithm algorithm = context.getBean(SortingAlgorithm.class);
    logger.debug(algorithm);

    SomeService service = context.getBean(SomeService.class);
    logger.debug(service.algorithm);

  }
}
