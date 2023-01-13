package pojo;

public class Subject {
	private int rollNo;
	private String Subject1;
	private String Subject2;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getSubject1() {
		return Subject1;
	}
	public void setSubject1(String subject1) {
		Subject1 = subject1;
	}
	public String getSubject2() {
		return Subject2;
	}
	public void setSubject2(String subject2) {
		Subject2 = subject2;
	}
	@Override
	public String toString() {
		return "Subject [ Subject1=" + Subject1 + ", Subject2=" + Subject2 + "]";
	}
	
	
}
