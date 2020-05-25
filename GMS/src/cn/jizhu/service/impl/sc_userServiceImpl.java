package cn.jizhu.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.jizhu.dao.Ec_userDao;
import cn.jizhu.dao.sc_userDao;
import cn.jizhu.dao.impl.EC_userDaoImpl;
import cn.jizhu.dao.impl.sc_userDaoImpl;
import cn.jizhu.javabean.EC_user;
import cn.jizhu.javabean.pageResult;
import cn.jizhu.javabean.sc_user;
import cn.jizhu.service.sc_userService;

public class sc_userServiceImpl implements sc_userService {

	public List<sc_user> findscByuser(String now_sno,String school_year,String term) {

		return new sc_userDaoImpl().findscByuser(now_sno,school_year, term);
	}
	public List<sc_user> findscAllByuser(String te_name) {

		return new sc_userDaoImpl().findscAllByuser(te_name);
	}
	public sc_user findByUser(String now_sno) {

		return new sc_userDaoImpl().findByUser(now_sno);
	}

	public sc_user login(sc_user user) {

		return null;
	}
	public int re_sc(sc_user user) {
		sc_userDao userDao = new sc_userDaoImpl();
		return userDao.re_sc(user);
	}
	public int add_sc(sc_user user ,String term,String school_year) {
		sc_userDao userDao = new sc_userDaoImpl();
		return userDao.add_sc(user,term,school_year);
	}
	public pageResult<sc_user> find_sc_bypage(String te_name,String school_year,int page,String term) throws SQLException
	{
		sc_userDao userDao = new sc_userDaoImpl();
		return userDao.find_sc_bypage(te_name,school_year,page,term);
	}
	public pageResult<sc_user> find_scrank_bypage(String te_name,String school_year,int page,String term) throws SQLException
	{
		sc_userDao userDao = new sc_userDaoImpl();
		return userDao.find_scrank_bypage(te_name,school_year,page,term);
	}
	public sc_user select_teacher_cno(String tno,String school_year,String term)
	{
		sc_userDao userDao = new sc_userDaoImpl();
		return userDao.select_teacher_cno(tno,school_year,term);
	}
	public String select_open_sc()
	{
		sc_userDao userDao = new sc_userDaoImpl();
		return userDao.select_open_sc();
	}
	public pageResult<sc_user> find_scrank_bystu(String school_year,int page,String term) throws SQLException
	{
		sc_userDao userDao = new sc_userDaoImpl();
		return userDao.find_scrank_bystu(school_year, page, term);
	}
	
}
