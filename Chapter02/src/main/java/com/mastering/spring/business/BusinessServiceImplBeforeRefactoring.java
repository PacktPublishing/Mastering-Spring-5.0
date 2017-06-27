package com.mastering.spring.business;

import com.mastering.spring.beans.Data;
import com.mastering.spring.beans.User;
import com.mastering.spring.data.DataServiceImpl;

public class BusinessServiceImplBeforeRefactoring {

  public long calculateSum(User user) {
    DataServiceImpl dataService = new DataServiceImpl();

    long sum = 0;
    for (Data data : dataService.retrieveData(user)) {
      sum += data.getValue();
    }

    return sum;

  }
}
