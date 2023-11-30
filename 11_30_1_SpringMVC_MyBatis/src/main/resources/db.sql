select * from game;
select * from NOV29_STUDENT;
SELECT * FROM nov29_student ORDER BY s_no;

INSERT INTO NOV29_STUDENT VALUES(nov29_student_seq.nextval,'pin','33');
INSERT INTO nov29_student VALUES(nov29_student_seq.nextval,#{},#{});

CREATE TABLE nov30_test(
	t_title VARCHAR2(30 char) PRIMARY KEY,
	t_when date not null
);

INSERT INTO nov30_test VALUES('누구라도 쉽게 따라하는 DB',sysdate);

SELECT * FROM nov30_test;