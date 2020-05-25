package cn.jizhu.service.impl;

import cn.jizhu.dao.Ec_userDao;
import cn.jizhu.dao.impl.EC_userDaoImpl;
import cn.jizhu.javabean.EC_user;
import cn.jizhu.service.EC_userService;

public class EC_userServiceImpl implements EC_userService {
/*
	public EC_user login(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.findByUser(user);
	}
	public int register(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.register(user);
	}
	public int re_information(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.re_information(user);
	}
	public int re_password(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.re_password(user);
	}
	public EC_user findByUser(String username) {
		return new EC_userDaoImpl().findByUser(username);
	}
*/
	//学生
	public EC_user login_stu(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.findByUser_stu(user);
	}
	public int register_stu(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.register_stu(user);
	}
	public int re_information_stu(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.re_information_stu(user);
	}
	public int re_password_stu(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.re_password_stu(user);
	}
	public EC_user findByUser_stu(String username) {
		return new EC_userDaoImpl().findByUser_stu(username);
	}
	
	//教师
	public EC_user login_tea(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.findByUser_tea(user);
	}
	public int register_tea(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.register_tea(user);
	}
	public int re_information_tea(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.re_information_tea(user);
	}
	public int re_password_tea(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.re_password_tea(user);
	}
	public EC_user findByUser_tea(String username) {
		return new EC_userDaoImpl().findByUser_tea(username);
	}
	
	//管理员
	public EC_user login_adm(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.findByUser_adm(user);
	}
	public int register_adm(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.register_adm(user);
	}
	public int re_information_adm(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.re_information_adm(user);
	}
	public int re_password_adm(EC_user user) {
		Ec_userDao userDao = new EC_userDaoImpl();
		return userDao.re_password_adm(user);
	}
	public EC_user findByUser_adm(String username) {
		return new EC_userDaoImpl().findByUser_adm(username);
	}
}
