package cn.jizhu.service;
import java.util.List;

import cn.jizhu.javabean.EC_user;
import cn.jizhu.javabean.admin_user;
import cn.jizhu.javabean.courses_user;
import cn.jizhu.javabean.sc_user;

public interface administratorService {
	List<sc_user> findCourses(String now_sno,String school_year,String term);
	int re_information(admin_user user);
	int admin_courses_delete(courses_user user);
	int notice(String notice);
	String select_notice();
	EC_user findBySdept(String student_username);
	int UpdateSdept(EC_user UpdateSdept);
	public int is_open_sc(String is_open);
	public String select_open_sc();
}