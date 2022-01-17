package tptty.example04;

public class AdvanceTicket extends Ticket {
	//필드
	private int advanceDays;

	//생성자
	public AdvanceTicket(int number, double price, int advanceDays) {
		super(number, price); //Ticket의 number와 price 초기화
		this.advanceDays = advanceDays; //내 멤버만 this로 초기화
	}

	//get & set
	public int getAdvanceDays() {
		return advanceDays;
	}

	public void setAdvanceDays(int advanceDays) {
		this.advanceDays = advanceDays;
	}

	//부모와 가격을 계산하는 방법이 다름 : 부모메소드 override (getPrice)
	@Override
	public double getPrice() { //추상메소드 오버라이드해서 사용가능
		if(this.advanceDays>=30)
			return super.getPrice()*0.7;
		//굳이 부모의 getPrice를 이용하지 않고, return this.price*0.7;로 변경
		//price가 protected로 선언되었으므로 자식클래스에선 그냥 사용가능
		//다른 클래스도 마찬가지
		else if(this.advanceDays>=20)
			return super.getPrice()*0.8;
		else if(this.advanceDays>=10)
			return super.getPrice()*0.9;
		else
			return super.getPrice();
	}

	@Override
	public String toString() { //부모의 getPrice인지 AdvanceTicket의 getPrice인지 확인
		
		return super.toString()+"\n배열: "+this.getAdvanceDays()+"일 전\n결제금액: "+this.getPrice()+"\n";
	}
	
	
	
}
