package tptty.example04;

//Ticket을 추상클래스로 변경 : 더 이상 객체 생성불가
//오류발생 : TestMain에서 Ticket객체 생성 불가능 (GeneralTicket이나 AdvanceTicket은 생성가능 : 상관x, 본인의 객체만 생성 불가, 자식을 통한 생성은 가능)
public class Ticket { //final : 상속받은 General/AdvanceTicket생성 불가
	//필드
	protected int number;
	protected double price;
	
	//Q : Ticket을 추상클래스로 변경하면 어차피 객체를 생성할 수 없는데, 생성자가 필요한가?
	//A : 필요하다. Ticket이 객체를 생성할 수 없을 뿐이지 자식클래스에서는 생성자를 이용해서 객체를 생성해야하기때문
	//생성자
	public Ticket() {
		this(0,0.0);
	}
	
	public Ticket(int number) {
		this(number, 0.0);
	}

	public Ticket(int number, double price) {
		this.number = number;
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

//	public abstract double getPrice(); //추상 메소드 : 반환할 값을 자식클래스에서 생성
	//메소드 중 하나를 abstract로 바꿔주면 이를 포함한 클래스는 자동으로 abstract로 변경됨
	//반드시 자식클래스에서 오버라이딩
	
	public double getPrice() { //final : 자식클래스에서 override불가능(재정의 불가능)
		return price; //티켓의 원래 가격 그대로 반환
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		
		return "티켓번호: " + this.number + "\n"+"티켓가격: " + this.price;
	}
	
}
