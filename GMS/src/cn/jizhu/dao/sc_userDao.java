package cn.jizhu.dao;
import java.sql.SQLException;
import java.util.List;

import cn.jizhu.javabean.EC_user;
import cn.jizhu.javabean.pageResult;
import cn.jizhu.javabean.sc_user;

public interface sc_userDao {
	
	List<sc_user> findscAllByuser(String te_name);
	List<sc_user> findscByuser(String now_sno,String school_year,String term);
	sc_user findByUser(sc_user user);//这是一个抽象方法，定义规则
	sc_user findByUser(String now_sno);
	int re_sc(sc_user user);
	int add_sc(sc_user user,String term,String school_year);
	public sc_user select_teacher_cno(String tno,String school_year,String term);
	public pageResult<sc_user> find_sc_bypage(String te_name,String school_year,int page,String term) throws SQLException;
	public String select_open_sc();
	public pageResult<sc_user> find_scrank_bypage(String te_name,String school_year,int page,String term) throws SQLException;
	public pageResult<sc_user> find_scrank_bystu(String school_year,int page,String term) throws SQLException;
}
