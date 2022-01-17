package tptty.example01;

public class TestMain {

	public static void main(String[] args) {
		//BankManager실행 시, BankAccount 주석처리
//		System.out.println("==========BankAccount==========");
//		BankAccount acc1 = new BankAccount("홍길동", 1000);
//		BankAccount acc2 = new BankAccount("고길동");
//		System.out.println(acc1); //acc1의 주소값을 출력 (BankAccount.java 65~74까지 없는 경우)
//		System.out.println(acc2);
//		//System.out.println : (인수)를 문자열(String)으로 변환한 뒤 출력 -> 위의 예시에선 주소값이 문자열로 변환되어 출력됨
//		
//		//Q. acc1의 주소값이 아니라 acc1이 가진 값을 출력하려면? (지금은 Object클래스가 가지고 있는 객체를 String으로 변환시켜주는 함수 자동호출)
//		//A. BackAccount.java참조 -> 변경해주면 주소값이 출력되지 않고, 내가 원하는 값 출력(BankAccount.java 68~70)
//		
//		System.out.println("==========acc1의 입출금==========");
//		acc1.deposit(1000);
//		acc1.withdraw(3000);
//		System.out.println(acc1);
//		System.out.println("==========acc1의 계좌이체==========");
//		acc1.transfer(acc2, 1000);
//		System.out.println(acc1);
//		System.out.println(acc2);
		
		System.out.println("\n\n==========BankManager==========");
		BankManager bank1 = new BankManager("건국은행", 10);
		BankManager bank2 = new BankManager("대학은행", 20);
		
		System.out.println("==========건국은행==========");
		bank1.createAccount(); //계좌번호 1
		bank1.createAccount(); //계좌번호 2
		bank1.deposit(); 
		bank1.withdraw();
		bank1.transfer(); //만약 타은행과 계좌이체를 하고싶다면? BankManager를 관리하는 새로운 클래스 생성
		//->지점검색->해당 은행 Manager로부터 계좌검색
		System.out.println(bank1);
		
		System.out.println("==========대학은행==========");
		bank2.createAccount();
		System.out.println(bank2); //계좌번호는 count를 static으로 선언해놓아서 누적 : 3
		
		
	}

}
