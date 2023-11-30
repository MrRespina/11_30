package com.ji.spring007.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ji.spring007.student.StudentDAO;

@Controller
public class TestController {
	
	@Autowired
	private TestDAO tDAO;
	
	@Autowired
	private StudentDAO sDAO;
	
	@RequestMapping(value = "/test.reg", method = RequestMethod.GET)
	public String insert(Test t,HttpServletRequest req) {
		tDAO.insertTest(t,req);
		tDAO.getAllTest(req);
		sDAO.getAllStudent(req);
		req.setAttribute("r", "테스트 등록 성공!");
		return "index";
	}
	
	@RequestMapping(value = "/test.search", method = RequestMethod.GET)
	public String search(HttpServletRequest req) {
		tDAO.getAllTest(req);
		return "index";
	}

}
