package cn.jizhu.service;

import cn.jizhu.javabean.EC_user;

public interface EC_userService {
/*	EC_user login(EC_user user);
	EC_user findByUser(String username);
	int register(EC_user user);
	int re_information(EC_user user);	
	int re_password(EC_user user);*/
	//学生
	EC_user login_stu(EC_user user);
	EC_user findByUser_stu(String username);
	int register_stu(EC_user user);
	int re_information_stu(EC_user user);	
	int re_password_stu(EC_user user);
	//教师
	EC_user login_tea(EC_user user);
	EC_user findByUser_tea(String username);
	int register_tea(EC_user user);
	int re_information_tea(EC_user user);	
	int re_password_tea(EC_user user);
	//管理员
	EC_user login_adm(EC_user user);
	EC_user findByUser_adm(String username);
	int register_adm(EC_user user);
	int re_information_adm(EC_user user);	
	int re_password_adm(EC_user user);
}
