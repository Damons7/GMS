
package cn.jizhu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jizhu.dao.administratorDao;
import cn.jizhu.javabean.EC_user;
import cn.jizhu.javabean.admin_user;
import cn.jizhu.javabean.courses_user;
import cn.jizhu.javabean.sc_user;
import cn.jizhu.util.Get_sc_gpa;
import cn.jizhu.util.JDBCUtil;

public class administratorDaoImpl implements administratorDao {
		//找回密码
		public int re_information(admin_user user) {
			String sql6=null;
		if(user.getLogin_name().length()==8)
		{ sql6 = "update student set password=? where login_name=?; ";}
		else if(user.getLogin_name().length()==3)
		{
		sql6 = "update teacher set password=? where login_name=?; ";}
	String[] info6 = {user.getPassword(),user.getLogin_name()};
	int rs =JDBCUtil.executeUpdate(sql6, info6);

		return rs;
	}
	
	public List<sc_user> findCourses(String now_sno,String school_year,String term) {

		String sql = "select student.sno,sc1.cno, new_courses.cname,sc1.grade from student,sc1,new_courses where " +
				"sc1.sno=student.sno and sc1.cno=new_courses.cno and new_courses.sno=student.sno and " +
				"student.sno=? and new_courses.school_year=? and new_courses.term=?";
		String info[] = { now_sno,school_year,term };
		
		ResultSet rs1 = JDBCUtil.executeQuery(sql, info);
	
		List<sc_user> coList1 = new ArrayList<sc_user>();
	
		try {
			String gpa1=null;
			while (rs1.next()) {
				sc_user co1 = new sc_user();
				Get_sc_gpa gpa=new  Get_sc_gpa();
				co1.setSno(rs1.getString("sno"));
				co1.setGrade(rs1.getDouble("grade"));
				co1.setCno(rs1.getString("cno"));
				co1.setCname(rs1.getString("cname"));
				//co1.setTno(rs1.getString("tno"));
				gpa1=String.format("%.1f",gpa.getGpa(rs1.getDouble("grade")));
				co1.setGpa(gpa1);
				coList1.add(co1);
			}
			

			return coList1;

		} catch (SQLException e) {
	
			e.printStackTrace();
		}

		return null;
	}
	
	public int admin_courses_delete(courses_user user) {

		String sql ="delete from courses_new where courses_new.sno=? and courses_new.cno=? ;";
		String[] info = {user.getSno(),user.getCno1()};
		int rs =JDBCUtil.executeUpdate(sql, info);
		return rs;
	}
	
	//公告
	public int notice(String notice) {

		String sql = "update notice set notice=?;";
		String[] info = {notice};
		int rs =JDBCUtil.executeUpdate(sql, info);
		return rs;
	}
	public String select_notice() {
		String sql = "select notice from notice;";
		
		ResultSet rs = JDBCUtil.executeQuery(sql, null);

		try {
			
			while (rs.next()) {
			
				String notice1=rs.getString("notice");
				
				return notice1;
			}

		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		return null;
	}
	
	public EC_user findBySdept(String student_username) {
		String  sql = "select * from ec_user where sno=?;";
		String info[] = {student_username};
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		
	
			EC_user user = new EC_user();
			try {
				while(rs.next()) {
					user.setSno(rs.getString("sno"));
					user.setName(rs.getString("name"));
					user.setSex(rs.getString("sex"));
					user.setSdept(rs.getString("sdept"));
					return user;
					
				}
				System.out.println("1:"+user.getSno());
				System.out.println("2:"+user.getName());
				System.out.println("3:"+user.getSex());
				System.out.println("4:"+user.getSdept());
				
			} catch (SQLException e) {
			
				e.printStackTrace();
		}
		
	
		return null;
	}
	//专业
	public int UpdateSdept(EC_user UpdateSdept) {

		String sql = "update ec_user set sdept=? where sno=?;";
		String[] info = {UpdateSdept.getSdept(),UpdateSdept.getSno()};
		int rs =JDBCUtil.executeUpdate(sql, info);
		return rs;
	}
	//开放修改成绩
	public int is_open_sc(String is_open) {

		String sql = "update open set open_sc=?; ";
		String[] info={is_open};
		int rs =JDBCUtil.executeUpdate(sql,info);
		return rs;
	}
	//查询是否开放
	public String select_open_sc() {
		String  sql = "select open_sc from open;";
	
		ResultSet rs = JDBCUtil.executeQuery(sql, null);
		
			try {
				while(rs.next()) {			
				return rs.getString("open_sc");					
				}		
			} catch (SQLException e) {
				e.printStackTrace();
		}		
		return null;
	}
	
}
