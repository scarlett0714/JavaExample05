package tptty.example04;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("202110547 황윤선");
		System.out.println("**** Ticket ****");
		Ticket ticket1 = new Ticket(1, 1000);
		System.out.println(ticket1);
		ticket1.setPrice(2000);
		System.out.println(ticket1);
		System.out.println();
		
		System.out.println("**** GeneralTicket ****");
		GeneralTicket t1 = new GeneralTicket(1,5000.0, false); //1, 5000.0->Ticket, false->GeneralTicket
		GeneralTicket t2 = new GeneralTicket(2,2000.0, true);
		System.out.println(t1);
		System.out.println(t2);
		System.out.println();
		
		System.out.println("**** AdvanceTicket ****");
		AdvanceTicket t3 = new AdvanceTicket(3, 1000.0, 32);
		AdvanceTicket t4 = new AdvanceTicket(4, 1000.0, 15);
		System.out.println(t3);
		System.out.println(t4);
		System.out.println();
		
		System.out.println("**** TicketManager ****");
		TicketManager ticket2 = new TicketManager("아이유 콘서트", 100);
		ticket2.register(new Ticket(5, 1000)); //티켓 구매
		ticket2.register(new GeneralTicket(6, 2000.0, true));
		ticket2.register(new GeneralTicket(7, 3000.0, false));
		ticket2.register(new AdvanceTicket(8, 3000.0, 35));
		ticket2.register(new GeneralTicket(9, 2000.0, true));
		ticket2.register(new AdvanceTicket(10, 3000.0, 15));
		
		System.out.println(ticket2);
		ticket2.showGeneralTicket(true); //GeneralTicket 중, 카드결제 한 것만 출력
		ticket2.showGeneralTicket(false); //GeneralTicket 중, 현금결제 한 것만 출력
		System.out.print("day를 입력하세요 : ");
		int day = scan.nextInt();
		ticket2.showAdvanceTicket(day); //AdvanceTicket
		scan.close();
	}

}
