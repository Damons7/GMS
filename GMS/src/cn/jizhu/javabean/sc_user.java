package cn.jizhu.javabean;

import java.util.List;

public class sc_user {
	private String name;
	private String cname;
	private double grade;
	private String gpa;
	private String sno;
	private String tno;
	private String cno;
	private int rank;
	
	//private String scType;

	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	/*public String getScType() {
		return scType;
	}
	public void setScType(String scType) {
		this.scType = scType;
	}*/
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	
	public String getCname(){
		return cname;
	}
	public void setCname(String cname){
		this.cname = cname;
	}
	public double getGrade(){
		return grade;
	}
	public void setGrade(double grade){
		this.grade = grade;
	}

	public String getSno(){
		return sno;
	}
	public void setSno(String sno){
		this.sno = sno;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
