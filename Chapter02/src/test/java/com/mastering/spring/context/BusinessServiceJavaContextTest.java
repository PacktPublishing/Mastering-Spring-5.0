package com.mastering.spring.context;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mastering.spring.beans.User;
import com.mastering.spring.business.BusinessService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/BusinessApplicationContext.xml" })
public class BusinessServiceJavaContextTest {
  private static final User DUMMY_USER = new User("dummy");

  @Autowired
  private BusinessService service;

  @Test
  public void testCalculateSum() {
    long sum = service.calculateSum(DUMMY_USER);
    assertEquals(30, sum);
  }

}
