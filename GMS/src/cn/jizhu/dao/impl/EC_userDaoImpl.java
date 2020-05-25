package cn.jizhu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jizhu.dao.Ec_userDao;
import cn.jizhu.javabean.EC_user;
import cn.jizhu.util.JDBCUtil;
import cn.jizhu.action.*;

public class EC_userDaoImpl implements Ec_userDao {
/*
	public EC_user findByUser(EC_user user) {
		String sql = "select * from ec_user where login_name=? ;";
		String[] info = { user.getLogin_name() };
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		try {
			EC_user rsUser = new EC_user();
			while (rs.next()) {
				rsUser.setLogin_name(rs.getString("login_name"));
				rsUser.setPassword(rs.getString("password"));
				rsUser.setIdentity(rs.getString("identity"));
				rsUser.setAddress(rs.getString("address"));
				rsUser.setAddress(rs.getString("sdept"));
				rsUser.setPhone(rs.getString("phone"));
				rsUser.setSex(rs.getString("SEX"));
				rsUser.setName(rs.getString("NAME"));
				rsUser.setSno(rs.getString("sno"));
				rsUser.setPassword(rs.getString("password"));
				return rsUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;// 如果没有这个人则返回null
	}

	// 插入用户的方法
	public int register(EC_user user) {
		String sql = "insert into ec_user(LOGIN_NAME,PASSWORD,NAME,SEX,PHONE,ADDRESS,SNO,SDEPT)values(?,?,?,?,?,?,?,?);";
		String[] info = { user.getLogin_name(), user.getPassword(),
				user.getName(), user.getSex(), user.getPhone(),
				user.getAddress(), user.getSno(), user.getSdept() };
		int rs = JDBCUtil.executeUpdate(sql, info);// 完成插入的操作
		return rs;
	}

	public int re_information(EC_user user) {
		String sql5 = "update ec_user set  address=? ,phone=? where LOGIN_NAME=?;";
		String[] info5 = { user.getAddress(), user.getPhone(),
				user.getLogin_name() };
		int rs = JDBCUtil.executeUpdate(sql5, info5);// 完成插入的操作
		return rs;
	}

	public int re_password(EC_user user) {
		String sql5 = "update ec_user set password=? where LOGIN_NAME=?;";
		String[] info5 = { user.getPassword(), user.getLogin_name() };
		int rs = JDBCUtil.executeUpdate(sql5, info5);// 完成插入的操作
		return rs;
	}

	// 以用户名查询数据
	@Override
	public EC_user findByUser(String username) {
		String sql = "select * from ec_user where login_name=?;";
		String info[] = { username };
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		EC_user user = new EC_user();
		try {
			while (rs.next()) {
				user.setAddress(rs.getString("address"));
				user.setSno(rs.getString("sno"));
				user.setName(rs.getString("name"));
				user.setLogin_name(rs.getString("LOGIN_NAME"));
				user.setSex(rs.getString("sex"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setSdept(rs.getString("sdept"));
				user.setPassword(rs.getString("password"));
				return user;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}*/
	
	//学生
	public EC_user findByUser_stu(EC_user user) {
		String sql = "select * from student where login_name=? ;";
		String[] info = { user.getLogin_name() };
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		try {
			EC_user rsUser = new EC_user();
			while (rs.next()) {
				rsUser.setLogin_name(rs.getString("login_name"));
				rsUser.setPassword(rs.getString("password"));
				rsUser.setIdentity(rs.getString("identity"));
				rsUser.setAddress(rs.getString("address"));
				rsUser.setSdept(rs.getString("sdept"));
				rsUser.setPhone(rs.getString("phone"));
				rsUser.setSex(rs.getString("SEX"));
				rsUser.setName(rs.getString("NAME"));
				rsUser.setSno(rs.getString("sno"));
				rsUser.setEmail(rs.getString("email"));
				return rsUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;// 如果没有这个人则返回null
	}

	// 插入用户的方法
	public int register_stu(EC_user user) {
		String sql = "insert into student(LOGIN_NAME,PASSWORD,NAME,SEX,PHONE,ADDRESS,SNO,SDEPT)values(?,?,?,?,?,?,?,?);";
		String[] info = { user.getLogin_name(), user.getPassword(),
				user.getName(), user.getSex(), user.getPhone(),
				user.getAddress(), user.getSno(), user.getSdept() };
		int rs = JDBCUtil.executeUpdate(sql, info);// 完成插入的操作
		return rs;
	}

	public int re_information_stu(EC_user user) {
		String sql5 = "update student set  address=? ,phone=? where LOGIN_NAME=?;";
		String[] info5 = { user.getAddress(), user.getPhone(),
				user.getLogin_name() };
		int rs = JDBCUtil.executeUpdate(sql5, info5);// 完成插入的操作
		return rs;
	}

	public int re_password_stu(EC_user user) {
		String sql5 = "update student set password=? where LOGIN_NAME=?;";
		String[] info5 = { user.getPassword(), user.getLogin_name() };
		int rs = JDBCUtil.executeUpdate(sql5, info5);// 完成插入的操作
		return rs;
	}

	// 以用户名查询数据
	@Override
	public EC_user findByUser_stu(String username) {
		String sql = "select * from student where login_name=?;";
		String info[] = { username };
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		EC_user user = new EC_user();
		try {
			while (rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setSno(rs.getString("sno"));
				user.setName(rs.getString("name"));
				user.setLogin_name(rs.getString("LOGIN_NAME"));
				user.setSex(rs.getString("sex"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setSdept(rs.getString("sdept"));
				user.setPassword(rs.getString("password"));
				user.setIdentity(rs.getString("identity"));
				return user;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	//教师
	public EC_user findByUser_tea(EC_user user) {
		String sql = "select * from teacher where login_name=? ;";
		String[] info = { user.getLogin_name() };
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		try {
			EC_user rsUser = new EC_user();
			while (rs.next()) {
				rsUser.setLogin_name(rs.getString("login_name"));
				rsUser.setPassword(rs.getString("password"));
				rsUser.setIdentity(rs.getString("identity"));
				rsUser.setAddress(rs.getString("address"));
				rsUser.setPhone(rs.getString("phone"));
				rsUser.setSex(rs.getString("SEX"));
				rsUser.setName(rs.getString("NAME"));
				rsUser.setTno(rs.getString("tno"));
				rsUser.setEmail(rs.getString("email"));
				return rsUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;// 如果没有这个人则返回null
	}

	// 插入用户的方法
	public int register_tea(EC_user user) {
		String sql = "insert into ec_user(LOGIN_NAME,PASSWORD,NAME,SEX,PHONE,ADDRESS,SNO,SDEPT)values(?,?,?,?,?,?,?,?);";
		String[] info = { user.getLogin_name(), user.getPassword(),
				user.getName(), user.getSex(), user.getPhone(),
				user.getAddress(), user.getSno(), user.getSdept() };
		int rs = JDBCUtil.executeUpdate(sql, info);// 完成插入的操作
		return rs;
	}

	public int re_information_tea(EC_user user) {
		String sql5 = "update teacher set  address=? ,phone=? where LOGIN_NAME=?;";
		String[] info5 = { user.getAddress(), user.getPhone(),
				user.getLogin_name() };
		int rs = JDBCUtil.executeUpdate(sql5, info5);
		return rs;
	}

	public int re_password_tea(EC_user user) {
		String sql5 = "update teacher set password=? where LOGIN_NAME=?;";
		String[] info5 = { user.getPassword(), user.getLogin_name() };
		int rs = JDBCUtil.executeUpdate(sql5, info5);
		return rs;
	}

	// 以用户名查询数据
	@Override
	public EC_user findByUser_tea(String username) {
		String sql = "select * from teacher where login_name=?;";
		String info[] = { username };
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		EC_user user = new EC_user();
		try {
			while (rs.next()) {
				user.setAddress(rs.getString("address"));
				user.setTno(rs.getString("tno"));
				user.setName(rs.getString("name"));
				user.setLogin_name(rs.getString("LOGIN_NAME"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setIdentity(rs.getString("identity"));
				user.setPassword(rs.getString("password"));
				return user;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	//管理员
	public EC_user findByUser_adm(EC_user user) {
		String sql = "select * from administartor where login_name=? ;";
		String[] info = { user.getLogin_name() };
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		try {
			EC_user rsUser = new EC_user();
			while (rs.next()) {
				rsUser.setLogin_name(rs.getString("login_name"));
				rsUser.setPassword(rs.getString("password"));
				rsUser.setIdentity(rs.getString("identity"));
				rsUser.setAddress(rs.getString("address"));
				rsUser.setPhone(rs.getString("phone"));
				rsUser.setSex(rs.getString("SEX"));
				rsUser.setName(rs.getString("NAME"));
				rsUser.setEmail(rs.getString("email"));
				return rsUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;// 如果没有这个人则返回null
	}

	// 插入用户的方法
	public int register_adm(EC_user user) {
		String sql = "insert into administartor(LOGIN_NAME,PASSWORD,NAME,SEX,PHONE,ADDRESS,SNO,SDEPT)values(?,?,?,?,?,?,?,?);";
		String[] info = { user.getLogin_name(), user.getPassword(),
				user.getName(), user.getSex(), user.getPhone(),
				user.getAddress(), user.getSno(), user.getSdept() };
		int rs = JDBCUtil.executeUpdate(sql, info);// 完成插入的操作
		return rs;
	}

	public int re_information_adm(EC_user user) {
		String sq = "update administartor set  address=? ,phone=? where LOGIN_NAME=?;";
		String[] inf = { user.getAddress(), user.getPhone(),user.getLogin_name() };
	
		int rs = JDBCUtil.executeUpdate(sq, inf);
	
		return rs;
	}

	public int re_password_adm(EC_user user) {
		String sql5 = "update administartor set password=? where LOGIN_NAME=?;";
		
		String[] info5 = { user.getPassword(), user.getLogin_name() };
		int rs = JDBCUtil.executeUpdate(sql5, info5);// 完成插入的操作
		return rs;
	}

	// 以用户名查询数据
	@Override
	public EC_user findByUser_adm(String username) {
		String sql = "select * from administartor where login_name=?;";
		String info[] = { username };
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		EC_user user = new EC_user();
		try {
			
			while (rs.next()) {
				user.setAddress(rs.getString("address"));
				user.setName(rs.getString("name"));
				user.setLogin_name(rs.getString("LOGIN_NAME"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setIdentity(rs.getString("identity"));
				return user;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
