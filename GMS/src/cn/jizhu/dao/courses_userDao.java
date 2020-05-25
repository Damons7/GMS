package cn.jizhu.dao;
import java.util.List;

import cn.jizhu.javabean.courses_user;

public interface courses_userDao {
	
	List<courses_user> findCoursesByteacher(String tno,String school_year,String term);
	List<courses_user> findCoursesByuser(String now_sno,String school_year,String term);
	int courses_select(courses_user user);
	int courses_delete(courses_user user);
	boolean courses_max(String cno);
}
