package cn.jizhu.dao.impl;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jizhu.javabean.courses_user;
import cn.jizhu.dao.courses_userDao;

import cn.jizhu.util.JDBCUtil;
import cn.jizhu.action.*;
public class courses_userDaoImpl implements courses_userDao {

	

	public List<courses_user> findCoursesByuser(String now_sno,String school_year,String term) {

		String sql = " select student.sno,new_courses.cno,new_courses.cname,new_courses.tno from " +
				"student,new_courses where new_courses.sno=student.sno and student.sno=? and school_year=? and term=?; ;";
		String info[] = { now_sno,school_year,term };

		ResultSet rs = JDBCUtil.executeQuery(sql, info);

		List<courses_user> coList = new ArrayList<courses_user>();
		try {
			while (rs.next()) {
		
				courses_user co = new courses_user();
				
				co.setSno(rs.getString("sno"));
				co.setCno1(rs.getString("cno"));
			co.setCname(rs.getString("cname"));
			co.setTe_name(rs.getString("tno"));
				

				coList.add(co);
			}
			

			return coList;

		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		return null;
	}
	public List<courses_user> findCoursesByteacher(String tno,String school_year,String term) {

		String sql = "select new_courses.cno,new_courses.cname,new_courses.sno,student.name from new_courses," +
				"student where new_courses.tno=? and student.sno=new_courses.sno and new_courses.term=? and new_courses.school_year=? ;";
		String info[] = { tno ,school_year,term};
		
		ResultSet rs = JDBCUtil.executeQuery(sql, info);

		List<courses_user> teList = new ArrayList<courses_user>();
		try {
			while (rs.next()) {
		
				courses_user te = new courses_user();
				te.setName(rs.getString("name"));
				te.setSno(rs.getString("sno"));
				te.setCno1(rs.getString("cno"));
			te.setCname(rs.getString("cname"));
				teList.add(te);
			}
			
			return teList;

		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		return null;
	}
	public boolean courses_max(String cno) {

		String sql = "select *from courses_new where cno=?;";
		String info[] = { cno};

		ResultSet rs = JDBCUtil.executeQuery(sql, info);
	int a=0;

		try {
			while (rs.next()) {
			
	a++;
			}
			if(a>=5)

			return true;
			

		} catch (SQLException e) {
		
			e.printStackTrace();
		}
return false;
		
	}
	public int courses_select(courses_user user) {

		String sql = "insert into courses_new(cno,sno,cname,te_name)values(?,?,?,?);";
		String[] info = {user.getCno1(),user.getSno(),user.getCname(),user.getTe_name()};
		int rs =JDBCUtil.executeUpdate(sql, info);
		return rs;
	}
	
	public int courses_delete(courses_user user) {

		String sql ="delete from courses_new where courses_new.sno=? and courses_new.cno=? ;";
		String[] info = {user.getSno(),user.getCno1()};
		int rs =JDBCUtil.executeUpdate(sql, info);
		return rs;
	}

}