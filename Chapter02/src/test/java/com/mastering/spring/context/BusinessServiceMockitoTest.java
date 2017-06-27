package com.mastering.spring.context;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mastering.spring.beans.Data;
import com.mastering.spring.beans.User;
import com.mastering.spring.business.BusinessService;
import com.mastering.spring.business.BusinessServiceImpl;
import com.mastering.spring.data.DataService;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceMockitoTest {
  private static final User DUMMY_USER = new User("dummy");

  @Mock
  private DataService dataService;

  @InjectMocks
  private BusinessService service = new BusinessServiceImpl();

  @Test
  public void testCalculateSum() {
    BDDMockito.given(dataService.retrieveData(Matchers.any(User.class)))
    .willReturn(Arrays.asList(new Data(10), new Data(15), new Data(25)));

    long sum = service.calculateSum(DUMMY_USER);
    assertEquals(10 + 15 + 25, sum);
  }
}
