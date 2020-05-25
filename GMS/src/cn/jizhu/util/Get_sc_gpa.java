package cn.jizhu.util;

public class Get_sc_gpa {
	double gpa;
	public double getGpa(double grade)
	{
		if(grade<60)
			gpa=0.0;
		else
			if(grade<90)	
				gpa=1.0+(grade-60.0)*0.1;	
			else if(grade>90)
				gpa=4.0;
		return gpa;
	}
	

}
