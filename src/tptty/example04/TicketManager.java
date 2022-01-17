package tptty.example04;

public class TicketManager {

	//필드
	private String name; //공연명
	private final int NUMBER; //전체 티켓 수 
	
	//Q : Ticket이 추상클래스라면 Ticket[]배열 생성 가능한가요?
	//A : 배열이기때문에 가능. 오직 new로 Ticket 생성자를 호출하는 것만 허용x
	private Ticket[] tickets; //티켓을 저장할 배열
	private int count =0; //현재 판매된 티켓 수 
	
	//생성자
	public TicketManager(String name, int NUMBER) {
		super(); //super -> Object
		this.name = name;
		this.NUMBER = NUMBER;
		tickets = new Ticket[this.NUMBER]; //빈 방
	}
	
	//메소드
	public void register(Ticket ticket) { //현장예매, 사전예매 따로따로 메소드 만들 필요x->상속관계 이용
		//부모타입인 Ticket은 현장이든 사전이든 모두 받을 수 있음 (업캐스팅)
		if(this.count<this.NUMBER) { //공간이 있는 경우
			this.tickets[this.count++] = ticket; //현장이든 사전이든 어떤 티켓이 들어오든 모두 저장 가능 why?부모타입으로 받음(업캐스팅) = 한 바구니에 모두 담음
		}
		else
			System.out.println("티켓 판매 완료");
	}
	public double getTotal() {
		double total = 0.0;
		for(Ticket ticket:tickets) { //ticket정보를 하나씩 다 불러옴
			if(ticket!=null) {
				//Q : Ticket이 추상클래스라면, getPrice는 Ticket에서 정의되지 않았는데 호출가능한가요?
				//A : 네. Ticket에 있는 걸 부르는 게 아니라, 자식클래스의 getPrice를 호출하는 것
				total += ticket.getPrice(); //앞에서 getPrice()는 오버라이딩되어있음
				//입력받는 ticket에 걸맞게 getPrice()호출 (다형성)
			}
			else //빈 방 
				break;
		}
		
		return total;
	}
	
	//+tickets배열에 모든 티켓을 모아놨는데, 종류별로 찾고싶은 경우->다운캐스팅
	public void showGeneralTicket(boolean payByCredit) { //tickets배열에서 GeneralTicket찾기
		for(Ticket ticket:tickets) {
			if(ticket!=null && ticket instanceof GeneralTicket) { //티켓이 있고, 그 티켓의 원래타입이 GeneralTicket이니?
				GeneralTicket t = (GeneralTicket)ticket; //업캐스팅해서 tickets에 담아놓은 것을 원래 본인의 것으로 변경 (다운캐스팅)
				if(t.isPayBycredit()==payByCredit) { //GeneralTicket중에서 카드결제티켓이라면?
					System.out.println(t);
				}
				
			}
		}
	}
	
	public void showAdvanceTicket(int day) { //tickets배열에서 AdvanceTicket찾기
		for(Ticket ticket:tickets) {
			if(ticket!=null && ticket instanceof AdvanceTicket) { //티켓이 있고, 그 티켓의 원래타입이 AdvanceTicket이니?
					AdvanceTicket t = (AdvanceTicket)ticket; //업캐스팅해서 tickets에 담아놓은 것을 원래 본인의 것으로 변경 (다운캐스팅)
					if(t.getAdvanceDays()>day) { //AdvanceTicket중에서 사용자가 입력한 일 이전에 예약된 티켓이라면?
						System.out.println(t);
					
					}
				}
				
			}
		}

	@Override
	public String toString() {
		String str = "공연명: "+this.name+"\n";
		str += "좌석수: "+this.NUMBER+"\n";
		str += "총 판매티켓 수: "+this.count+"\n";
		
		for(Ticket ticket:tickets) {
			if(ticket!=null) {
				str += ticket.toString(); //각각의 티켓이 가리키는 toString호출 (다형성)
				str += "\n------------\n";
			}
			else
				break;
		}
		str +="총 티켓 판매 금액: "+this.getTotal()+"\n";
				
		return str;
	}
	
	
	
}
