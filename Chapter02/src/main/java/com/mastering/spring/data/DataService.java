package com.mastering.spring.data;

import java.util.List;

import com.mastering.spring.beans.Data;
import com.mastering.spring.beans.User;

public interface DataService {
  List<Data> retrieveData(User user);
}
