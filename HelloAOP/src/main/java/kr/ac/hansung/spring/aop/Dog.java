package kr.ac.hansung.spring.aop;

public class Dog implements AnimalType {

	private String myName;

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public void sound() {
		System.out.println("Dog name = " +  myName + ": " + "Bow Wow");
	}

}
