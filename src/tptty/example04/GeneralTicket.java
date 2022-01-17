package tptty.example04;

//클래스 생성 시, superclass : Object->Ticket으로 변경
//다른 패키지에 부모클래스가 있다면 앞에 경로도 입력
public class GeneralTicket extends Ticket { //생성자가 명시되지 않은 경우, 자동으로 디폴트생성자 호출->Ticket에 디폴트생성자 필요

	//필드
	private boolean payBycredit; //T:카드 결제 or F:현금 결제 여부 결정

	//생성자
	public GeneralTicket(int number) { //부모생성자의 number만 변경하는 생성자
		super(number);
	}
	public GeneralTicket(int number, boolean payBycredit) {
		//this와 super는 동시 사용불가
		this(number, 0.0, payBycredit); //super(number);와 같은 코드
		this.payBycredit = payBycredit;
	}
	//부모것도 매개변수로 가져오고 싶다면? 위에 창에서 클릭
	public GeneralTicket(int number, double price, boolean payBycredit) {
		super(number, price); //부모꺼
		this.payBycredit = payBycredit; //내꺼
	}
	
	//get & set
	public boolean isPayBycredit() { //boolean타입은 get이 아닌 is
		return payBycredit;
	}
	public void setPayBycredit(boolean payBycredit) {
		this.payBycredit = payBycredit;
	}
	
	//부모와 가격을 계산하는 방법이 다름 : 부모메소드 override (getPrice)
	@Override
	public double getPrice() {
		if(this.isPayBycredit()) //카드결제
			return super.getPrice()*1.1; //getPrice만 쓰면 GeneralTicket의 getPrice를 호출하는 줄 앎(오류 :재귀) -> 부모의 것임을 표현 : super
		else //현금결제
			return super.getPrice();
	}
	//override에서 Ticket에서 이미 Object의 toString을 오버라이드했기 때문에, Object의 toString은 숨김상태
	//Ticket과 다르게 출력하고 싶다면? Ticket의 toString을 오버라이드
	@Override
	public String toString() {
		
		//부모의 toString문을 출력하고, 뒤에 문자열 이어서 출력
		String str = super.toString()+"\n카드결제: "+this.isPayBycredit();
		str += "\n결제금액: "+this.getPrice()+"\n"; //부모의 getPrice가 아닌 GeneralTicket의 getPrice
		return str;
		
	}
	
	

	
	
	
	
	
	
}
