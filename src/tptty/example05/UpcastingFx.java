//업캐스팅 사례
package tptty.example05;

class Person {
	String name;
	String id;
	
	public Person(String name) {
		this.name = name;
		
	} 
}

class Student extends Person { //부모클래스 : Person, 자식클래스 : Student
	String grade;
	String department;
	
	public Student(String name) {
		super(name);
	}
}

public class UpcastingFx {

	public static void main(String[] args) {
		Person p;
		Student s = new Student("이재문");
		p = s; //업캐스팅 발생 (부모는 자식참조 가능 : 자동타입변환)
		
		System.out.println(p.name); //오류없음
		
//		컴파일 오류발생
		//오류원인 : p는 Person타입 맴버만 접근 가능, grade와 department는 Student가 가지고 있는 멤버
//		p.grade= "A";
//		p.department = "Com";

	}

}
