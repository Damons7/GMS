package cn.jizhu.dao.impl;
import java.util.List;import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jizhu.javabean.EC_user;
import cn.jizhu.javabean.pageResult;
import cn.jizhu.javabean.sc_user;
import cn.jizhu.dao.sc_userDao;
import cn.jizhu.util.Get_sc_gpa;
import cn.jizhu.util.JDBCUtil;
import cn.jizhu.action.*;
public class sc_userDaoImpl implements sc_userDao {
	public sc_user findByUser(String now_sno) {
		String  sql = "select student.sno,courses.cname,sc1.grade from student,sc1,courses where " +
				"sc1.sno=student.sno and sc1.cno=courses.cno and student.sno=? ;";
		String info[] = {now_sno};
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
			sc_user user = new sc_user();
			try {
				while(rs.next()) {				
					user.setSno(rs.getString("sno"));
					user.setCname(rs.getString("cname"));
					user.setGrade(rs.getDouble("grade"));	
					return user;					
				}		
			} catch (SQLException e) {
				e.printStackTrace();
		}		
		return null;
	}
	public List<sc_user> findscByuser(String now_sno,String school_year,String term) {
		String sql = "select student.sno,new_courses.cname,sc1.grade from student,sc1,new_courses where " +
				"sc1.sno=student.sno and sc1.cno=new_courses.cno and new_courses.sno=student.sno and " +
				"student.sno=? and new_courses.school_year=? and new_courses.term=?;";
		String info[] = { now_sno,school_year,term };
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		List<sc_user> scList = new ArrayList<sc_user>();
		try {
			String gpa1=null;
			while (rs.next()) {		
				sc_user sc = new sc_user();	
				Get_sc_gpa gpa=new  Get_sc_gpa();
				sc.setSno(rs.getString("sno"));
				sc.setCname(rs.getString("cname"));
				sc.setGrade(rs.getDouble("grade"));	
				gpa1=String.format("%.1f",gpa.getGpa(rs.getDouble("grade")));
				sc.setGpa(gpa1);
				scList.add(sc);
			}
			return scList;
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}
	public List<sc_user> findscAllByuser(String tno) {
		String sql = "select sc1.sno,student.name,sc1.cno,courses.cname,sc1.grade from " +
				"courses,sc1,student where courses.cno=sc1.cno and sc1.sno=student.sno and courses.tno=?;";
		String info[] = {tno};
		ResultSet rs = JDBCUtil.executeQuery(sql,info);
		List<sc_user> scAllList = new ArrayList<sc_user>();
		try {
			while (rs.next()) {
				sc_user scAll = new sc_user();			
				scAll.setSno(rs.getString("sno"));
				scAll.setName(rs.getString("name"));
				scAll.setCno(rs.getString("cno"));
				scAll.setCname(rs.getString("cname"));
				scAll.setGrade(rs.getDouble("grade"));
				scAllList.add(scAll);
			}
			return scAllList;
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return null;
	}
	public pageResult<sc_user> find_sc_bypage(String tno,String school_year,int page,String term) throws SQLException
	 {		
			String sql0 = "select count(*) page from sc1,courses where " +
					"courses.cno=sc1.cno and term=? and school_year=? and tno=?";
			String[] tno1 = { term,school_year,tno};
			ResultSet rs = JDBCUtil.executeQuery(sql0, tno1);
	     //1.创建pageresult对象
	     pageResult<sc_user> pr = new pageResult<sc_user>();
	     //2.设置总记录数
	     rs.next();
	     int totalcount = rs.getInt("page");
	     pr.setTotalCount(totalcount);
	           //3.设置总页数
	     int totalpage = (int) (totalcount % pr.getPageCount() == 0 ? totalcount / pr.getPageCount() : totalcount / pr.getPageCount() + 1);
	     pr.setTotalpage(totalpage);
	     //4.设置当前页
	     pr.setCurrentPage(page);
	     //5.放置list参数
	     pr.setTerm(term);
	     pr.setSchool_year(school_year);
	     int start = (page-1)* pr.getPageCount();
	     List<sc_user> user = findscAllByuser(start,pr.getPageCount(),tno,school_year,term);
	     pr.setList(user); 
	    List<sc_user> userq= pr.getList();
	     return pr;
	    }
	
	public List<sc_user> findscAllByuser(int star,int page ,String tno,String school_year,String term) {
		String star1=String.valueOf(star);
		String page1=String.valueOf(page);
		String sql = "select sc1.sno,student.name,sc1.cno,courses.cname,sc1.grade from" +
				" courses,sc1,student  where courses.cno=sc1.cno and sc1.sno=student.sno " +
						"and sc1.term=? and school_year=? and courses.tno=? limit "+star1+","+page1;
		String info[]={term,school_year,tno};
		ResultSet rs = JDBCUtil.executeQuery(sql,info);
		List<sc_user> scAllList = new ArrayList<sc_user>();
		try {
			String gpa2=null;
			while (rs.next()) {
				sc_user scAll = new sc_user();
				Get_sc_gpa gpa=new  Get_sc_gpa();
				scAll.setSno(rs.getString("sno"));   	
				scAll.setName(rs.getString("name"));
				scAll.setCno(rs.getString("cno"));
				scAll.setCname(rs.getString("cname"));
				scAll.setGrade(rs.getDouble("grade"));
			
				gpa2=String.format("%.1f",gpa.getGpa(rs.getDouble("grade")));
				scAll.setGpa(gpa2);
				
				scAllList.add(scAll);					
			}
			return scAllList;
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return null;
	}
	
	public pageResult<sc_user> find_scrank_bypage(String tno,String school_year,int page,String term) throws SQLException
	 {		
			String sql0 = "select count(*) page from sc1,courses where " +
					"courses.cno=sc1.cno and term=? and school_year=? and tno=?";
			String[] tno1 = { term,school_year,tno};
			ResultSet rs = JDBCUtil.executeQuery(sql0, tno1);
	     //1.创建pageresult对象
	     pageResult<sc_user> pr = new pageResult<sc_user>();
	     //2.设置总记录数
	     rs.next();
	     int totalcount = rs.getInt("page");
	     pr.setTotalCount(totalcount);
	           //3.设置总页数
	     int totalpage = (int) (totalcount % pr.getPageCount() == 0 ? totalcount / pr.getPageCount() : totalcount / pr.getPageCount() + 1);
	     pr.setTotalpage(totalpage);
	     //4.设置当前页
	     pr.setCurrentPage(page);
	     //5.放置list参数
	     pr.setTerm(term);
	     pr.setSchool_year(school_year);
	     int start = (page-1)* pr.getPageCount();
	     List<sc_user> user = findscrankAllByuser(start,pr.getPageCount(),tno,school_year,term,pr.getCurrentPage());
	     pr.setList(user); 
	    List<sc_user> userq= pr.getList();
	     return pr;
	    }
	
	public List<sc_user> findscrankAllByuser(int star,int page ,String tno,String school_year,String term,int currentPage) {
		String star1=String.valueOf(star);
		String page1=String.valueOf(page);
		String sql = "select sc1.sno,student.name,sc1.cno,courses.cname,sc1.grade from" +
				" courses,sc1,student  where courses.cno=sc1.cno and sc1.sno=student.sno " +
						"and sc1.term=? and school_year=? and courses.tno=?  order by grade desc limit "+star1+","+page1;
		String info[]={term,school_year,tno};
		ResultSet rs = JDBCUtil.executeQuery(sql,info);
		List<sc_user> scAllList = new ArrayList<sc_user>();
		try {
			String gpa2=null;int rank;
			if(currentPage==2){
				 rank=5;
				}
			else if(currentPage==3){
				 rank=10;
				}
			else if(currentPage==4){
				 rank=15;
				}
			else if(currentPage==5){
				 rank=20;
				}
			else
			{
				 rank=0;
			}
			while (rs.next()) {
				sc_user scAll = new sc_user();
				Get_sc_gpa gpa=new  Get_sc_gpa();
				scAll.setSno(rs.getString("sno"));   	
				scAll.setName(rs.getString("name"));
				scAll.setCno(rs.getString("cno"));
				scAll.setCname(rs.getString("cname"));
				scAll.setGrade(rs.getDouble("grade"));
				rank=rank+1;
				scAll.setRank(rank);
			 
				gpa2=String.format("%.1f",gpa.getGpa(rs.getDouble("grade")));
				scAll.setGpa(gpa2);
				
				scAllList.add(scAll);					
			}
			return scAllList;
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return null;
	}
	
//学生查询成绩排名
	public pageResult<sc_user> find_scrank_bystu(String school_year,int page,String term) throws SQLException
	 {		
			String sql0 = "select count(*) page from new_courses where " +
					"term=? and school_year=? and cno=1002 ";
			String[] tno1 = { term,school_year};
			ResultSet rs = JDBCUtil.executeQuery(sql0, tno1);
	     //1.创建pageresult对象
	     pageResult<sc_user> pr = new pageResult<sc_user>();
	     //2.设置总记录数
	     rs.next();
	     int totalcount = rs.getInt("page");
	     pr.setTotalCount(totalcount);
	           //3.设置总页数
	     int totalpage = (int) (totalcount % pr.getPageCount() == 0 ? totalcount / pr.getPageCount() : totalcount / pr.getPageCount() + 1);
	     pr.setTotalpage(totalpage);
	     //4.设置当前页
	     pr.setCurrentPage(page);
	     //5.放置list参数
	     pr.setTerm(term);
	     pr.setSchool_year(school_year);
	     int start = (page-1)* pr.getPageCount();
	     List<sc_user> user = findscrank_bystu(start,pr.getPageCount(),school_year,term,pr.getCurrentPage());
	     pr.setList(user); 
	    List<sc_user> userq= pr.getList();
	     return pr;
	    }
	
	public List<sc_user> findscrank_bystu(int star,int page ,String school_year,String term,int currentPage) {
		String star1=String.valueOf(star);
		String page1=String.valueOf(page);
		String sql = "  SELECT sno,SUM(grade) as grade,row_number()over(order by sum(grade) desc)as ra FROM " +
				"sc1 where school_year=? and term=? GROUP BY sno ORDER BY SUM(grade) desc  limit "+star1+","+page1+" ;";
		String info[]={term,school_year};
		ResultSet rs = JDBCUtil.executeQuery(sql,info);
		List<sc_user> scAllList = new ArrayList<sc_user>();
		try {
			String gpa2=null;int rank;
			if(currentPage==2){
				 rank=5;
				}
			else if(currentPage==3){
				 rank=10;
				}
			else if(currentPage==4){
				 rank=15;
				}
			else if(currentPage==5){
				 rank=20;
				}
			else
			{
				 rank=0;
			}
	
			while (rs.next()) {
				Get_sc_gpa gpa=new  Get_sc_gpa();
				sc_user scAll = new sc_user();
				scAll.setSno(rs.getString("sno"));   	
				scAll.setGrade(rs.getDouble("grade"));	
				rank=rank+1;
				scAll.setRank(rank);	 
				gpa2=String.format("%.1f",gpa.getGpa(rs.getDouble("grade")));
				scAll.setGpa(gpa2);

				scAllList.add(scAll);	
			}
			return scAllList;
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return null;
	}
	
	public int re_sc(sc_user user) {	
		String sql6 = "update sc1 set grade=? where sno=? and cno=?; ";
		String grade=String.valueOf(user.getGrade());
		String[] info6 = {grade,user.getSno(),user.getCno()};
		int rs =JDBCUtil.executeUpdate(sql6, info6);
		return rs;
	}

	public int add_sc(sc_user user,String term,String school_year) {
		String sql7 = "insert into sc1(sno,cno,grade,term,school_year)values(?,?,?,?,?);";
		String grade=String.valueOf(user.getGrade());
		System.out.println("发放"+term);
		System.out.println("发放"+school_year);
		String[] info7 = {user.getSno(),user.getCno(),grade,term,school_year};
		int rs =JDBCUtil.executeUpdate(sql7, info7);
		return rs;
	}

	public sc_user select_teacher_cno(String tno,String school_year,String term) {
		String  sql = "select cno,cname from new_courses where tno=? and school_year=? and term=? ;";
		String info[] = {tno,school_year,term};
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		List<sc_user> scList = new ArrayList<sc_user>();
		
			try {
				sc_user sc=new sc_user();
				while(rs.next()) {		
				
				sc.setCname(rs.getString("cname"));
				sc.setCno(rs.getString("cno"));
					return sc;		
				}		
			} catch (SQLException e) {
				e.printStackTrace();
		}		
		return null;
	}
	public sc_user findByUser(sc_user user) {	
		return null;
	}
	
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
	
	public String select_cno(String tno) {
		String  sql = "select cno from courses;";
	
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