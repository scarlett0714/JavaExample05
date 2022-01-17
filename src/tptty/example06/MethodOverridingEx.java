package tptty.example06;

class Shape {
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape { //Shape을 상속받아 자식클래스 생성
	public void draw() { //메소드 오버라이딩
		System.out.println("Line");
	}
}

class Rect extends Shape {
	public void draw() {
		System.out.println("Rect");
	}
}

class Circle extends Shape {
 public void draw() {
	 System.out.println("Circle");
 }
}

public class MethodOverridingEx {

	static void paint(Shape p) { //Shape타입의 매개변수
		p.draw(); //Shape이 가지고 있는 draw호출
		//Shape객체에 어떤 draw가 들어오냐에 따라서 호출되는 draw함수가 달라짐 : 동적바인딩
	}
	public static void main(String[] args) {
		Line line = new Line(); 
		paint(line); // Shape p = line; (업캐스팅) -> Line의 draw호출
		
		paint(new Shape()); //Shape의 draw호출
		paint(new Line()); //오버라이팅된 Line의 draw호출
		paint(new Rect()); 
		paint(new Circle()); 

	}

}
