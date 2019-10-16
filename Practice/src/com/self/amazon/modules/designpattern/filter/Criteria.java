package com.self.amazon.modules.designpattern.filter;

import java.util.List;

public interface Criteria {
	   public List<Person> meetCriteria(List<Person> persons);
}