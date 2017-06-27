package com.mastering.spring.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mastering.spring.beans.Data;
import com.mastering.spring.beans.User;

@Repository
public class DataServiceImpl implements DataService {
  public List<Data> retrieveData(User user) {
    return Arrays.asList(new Data(10), new Data(20));
  }
}
