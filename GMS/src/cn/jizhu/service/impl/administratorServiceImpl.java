package cn.jizhu.service.impl;

import java.util.List;

import cn.jizhu.dao.Ec_userDao;
import cn.jizhu.dao.administratorDao;

import cn.jizhu.dao.impl.EC_userDaoImpl;
import cn.jizhu.dao.impl.administratorDaoImpl;


import cn.jizhu.javabean.EC_user;
import cn.jizhu.javabean.admin_user;
import cn.jizhu.javabean.courses_user;
import cn.jizhu.javabean.sc_user;
import cn.jizhu.service.administratorService;

public class administratorServiceImpl implements administratorService {
	public int re_information(admin_user user) {
		administratorDao Dao = new administratorDaoImpl();
		return Dao.re_information(user);
	}
	public List<sc_user> findCourses(String now_sno,String school_year,String term) {

		return new administratorDaoImpl().findCourses(now_sno,school_year,term);
	}
	public int admin_courses_delete(courses_user user) {
		administratorDao userDao = new administratorDaoImpl();

		return userDao.admin_courses_delete(user);
	}
	public int notice(String notice) {
		administratorDao userDao = new administratorDaoImpl();
		return userDao.notice(notice);
	}
	public String select_notice() {
		administratorDao userDao = new administratorDaoImpl();
		return userDao.select_notice();
	}
	public EC_user findBySdept(String student_username) {
		administratorDao userDao = new administratorDaoImpl();
		return userDao.findBySdept(student_username);
	}
	public int UpdateSdept(EC_user UpdateSdept) {
		administratorDao userDao = new administratorDaoImpl();
		return userDao.UpdateSdept(UpdateSdept);
	}
	//开放修改成绩
	public int is_open_sc(String is_open)
	{
		administratorDao userDao = new administratorDaoImpl();
		return userDao.is_open_sc(is_open);
	}
	public String select_open_sc()
	{
		administratorDao userDao = new administratorDaoImpl();
		return userDao.select_open_sc();
	}
	
}
