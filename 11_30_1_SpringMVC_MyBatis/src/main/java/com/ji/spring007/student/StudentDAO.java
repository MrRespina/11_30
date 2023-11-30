package com.ji.spring007.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//	SqlSessionTemplate
//		SqlSession의 하위 클래스
//		public class SqlSessionTemplate implements SqlSession 의 구조
//		> Sqlsession의 기능은 다 사용 가능하고, 더 추가됨.
//		> 자동연결 / 자동해제
//		> 자동 Commit


@Service
public class StudentDAO {
	
	@Autowired
	private SqlSession ss;		// servlet-context.xml의 맨 마지막에 bean으로 담겨있음
	
	public void regStudent(Student s,HttpServletRequest req) {
		
		try {
			
			// 연결 > 자동으로 됨.(SqlSessionTemplate이 자동으로 해줌.) : connect, close 필요X
			
			// 값 받아오기 & 객체로 만들기 - Spring이 해결을 자동으로 해줌.
			
			
			//	SQL 수행 - MyBatis 사용
			//		Interface 가져올것
			StudentMapper sm = ss.getMapper(StudentMapper.class);
			
			//	interface에 있는 abstract method(추상메소드) 호출
			//	-자동-> 연결이 되어있는 mapper.xml의 해당 부분이 실행
			if(sm.regStudent(s)==1) {
				req.setAttribute("r", "등록 성공!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "등록 실패");
		}
		
	}
	
	public void getAllStudent(HttpServletRequest req) {
		
		try {
			
			List<Student> students = ss.getMapper(StudentMapper.class).getAllStudent();
			req.setAttribute("r", "학생 출력");
			req.setAttribute("students", students);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
