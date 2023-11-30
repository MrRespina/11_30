package com.ji.spring007.test;

import java.util.List;

public interface TestMapper {
	
	public abstract List<Test> searchTest();
	public abstract int insertTest(Test t);
	
}
