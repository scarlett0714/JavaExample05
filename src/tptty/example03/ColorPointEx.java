package tptty.example03;
class Point {
	private int x,y; //한 점을 구성하는 x,y좌표
	void set(int x, int y) { //값을 변경
		this.x = x;
		this.y = y;
		
	}
	//+예제) super()를 활용한 ColorPoint 작성
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Point() { //디폴트생성자를 호출한다면, 다른 생성자가 존재하기 때문에 추가생성필요
		// TODO Auto-generated constructor stub
	}
	//
	
	void showPoint() { //좌표 출력
		System.out.println("(" + x + "," + y + ")");
	}
}

class ColorPoint extends Point { //Point클래스->ColorPoint클래스로 상속
	
	private String color; //점의 색
	
	//+예제) super()를 활용한 ColorPoint 작성
	ColorPoint(int x, int y, String color) { //생성자 명시적 호출
		super(x,y); //Point의 생성자 Point(x,y)호출
		this.color = color;
	}
	public ColorPoint() { //디폴트생성자를 호출한다면, 다른 생성자가 존재하기 때문에 추가생성필요
		// TODO Auto-generated constructor stub
	}
	//
	
	void setColor(String color) { //자기자신의 멤버인 color만 변경
		this.color = color;
	}
	void showColorPoint() { //컬러 점의 좌표 출력
		System.out.print(color);
		showPoint(); //Point클래스의 메소드 호출가능(상속받음)
	}
}

public class ColorPointEx {

	public static void main(String[] args) {
		Point p = new Point(); //Point객체 생성(부모클래스)
		p.set(1,2); //Point가 가진 것만 액세스 가능
		p.showPoint();
		
		ColorPoint cp = new ColorPoint(); //ColorPoint객체 생성(자식클래스)
		cp.set(3,4); //Point, ColorPoint의 것 모드 액세스 가능
		cp.setColor("red");
		cp.showColorPoint();
		
		//+예제) super()를 활용한 ColorPoint 작성
		ColorPoint cp1 = new ColorPoint(5, 6, "blue"); //객체생성
		//부모클래스 Point가 가지는 5, 6값도 전달해야함
	
		cp1.showColorPoint();

	}

}
