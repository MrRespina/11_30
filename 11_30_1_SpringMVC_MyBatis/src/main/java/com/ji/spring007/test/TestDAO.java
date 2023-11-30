package com.ji.spring007.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDAO {

	@Autowired
	private SqlSession ss;

	public void getAllTest(HttpServletRequest req) {

		try {

			List<Test> tests = ss.getMapper(TestMapper.class).searchTest();
			req.setAttribute("r", "테스트 출력");
			req.setAttribute("tests", tests);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void insertTest(Test t,HttpServletRequest req) {

		try {
			String t_y=req.getParameter("t_y");
			int t_m = Integer.parseInt(req.getParameter("t_m"));
			int t_d = Integer.parseInt(req.getParameter("t_d"));
			
			String t_when2 = String.format("%s%02d%02d", t_y,t_m,t_d);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			
			Date t_when = sdf.parse(t_when2);
			t.setT_when(t_when);
			
			if(ss.getMapper(TestMapper.class).insertTest(t) == 1) {
				
				req.setAttribute("r", "테스트 입력 성공!");
				
			}else {
				
				req.setAttribute("r", "테스트 입력 실패!");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			req.setAttribute("r", "테스트 입력 실패!");
			
		}

	}

}
