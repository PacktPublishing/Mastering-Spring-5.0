package com.mastering.spring.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastering.spring.beans.Data;
import com.mastering.spring.beans.User;
import com.mastering.spring.data.DataService;

@Service
public class BusinessServiceImpl implements BusinessService {

  @Autowired
  private DataService dataService;

  public long calculateSum(User user) {
    long sum = 0;
    for (Data data : dataService.retrieveData(user)) {
      sum += data.getValue();
    }
    return sum;
  }

  public void setDataService(DataService dataService) {
    this.dataService = dataService;
  }

}
