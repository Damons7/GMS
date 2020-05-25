package cn.jizhu.dao;

import cn.jizhu.javabean.EC_user;

public interface Ec_userDao {

	//EC_user findByUser(EC_user user);
//	int register(EC_user user);
//	int re_information(EC_user user);	
//	int re_password(EC_user user);
//	EC_user findByUser(String username);
	
	//学生
	EC_user findByUser_stu(EC_user user);
	int register_stu(EC_user user);
	int re_information_stu(EC_user user);	
	int re_password_stu(EC_user user);
	EC_user findByUser_stu(String username);
	
	//教师
	EC_user findByUser_tea(EC_user user);
	int register_tea(EC_user user);
	int re_information_tea(EC_user user);	
	int re_password_tea(EC_user user);
	EC_user findByUser_tea(String username);
	
	//管理员
	EC_user findByUser_adm(EC_user user);
	int register_adm(EC_user user);
	int re_information_adm(EC_user user);	
	int re_password_adm(EC_user user);
	EC_user findByUser_adm(String username);

}
