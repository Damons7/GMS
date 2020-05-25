package cn.jizhu.service.impl;

import java.util.List;

import cn.jizhu.dao.Ec_userDao;
import cn.jizhu.dao.courses_userDao;
import cn.jizhu.dao.impl.EC_userDaoImpl;
import cn.jizhu.dao.impl.courses_userDaoImpl;
import cn.jizhu.javabean.EC_user;
import cn.jizhu.javabean.courses_user;
import cn.jizhu.service.courses_userService;

public class courses_userServiceImpl implements courses_userService {

	public List<courses_user> findCoursesByuser(String now_sno,String school_year,String term) {

		return new courses_userDaoImpl().findCoursesByuser(now_sno,school_year,term);
	}
	public List<courses_user> findCoursesByteacher(String tno,String school_year,String term) {

		return new courses_userDaoImpl().findCoursesByteacher(tno,school_year,term);
	}
	public int courses_select(courses_user user) {
		courses_userDao userDao = new courses_userDaoImpl();

		return userDao.courses_select(user);
	}

	public int courses_delete(courses_user user) {
		courses_userDao userDao = new courses_userDaoImpl();

		return userDao.courses_delete(user);
	}
	public boolean courses_max(String cno) {
		courses_userDao userDao = new courses_userDaoImpl();

		return userDao.courses_max(cno);
	}
}
