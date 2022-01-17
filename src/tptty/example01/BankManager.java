package tptty.example01;

import java.util.Scanner;

public class BankManager {

	//필드
	public String branchName; //지점명
	
//	public static final int NUM = 20; : 20개의 계좌정보 저장
	//Q : 만약, 각 지점별로 NUM의 숫자를 다르게 하고 싶다면?
	//A : static을 제외하고 그냥 상수라고만 표현
	public final int NUM;
	//모든 지점들이 20개씩만 계좌발급가능->BankAccount 객체를 20개 저장할 수 있는 빈 방 생성
	public BankAccount[] bankAccount;
	
	public int number = 0; //현재 배열에 들어가있는 계좌의 수 카운트
	
	public static Scanner scan = new Scanner(System.in);
	
	//생성자
	public BankManager(String branchName, int NUM) {
		this.NUM = NUM; //한 번 픽스되면 변경x
		this.bankAccount = new BankAccount[this.NUM]; //배열의 방 개수 지정
		this.branchName = branchName;
	}
	
	//메소드
	public void createAccount() { //계좌개설
		System.out.println("---------- 계좌 개설 ----------");
		if(number < NUM) { //현재 개설된 계좌 수 < 계좌 계설 가능 한도
			System.out.print("이름 : ");;
			String name = scan.next();
			System.out.print("입금할 금액 : ");
			double amount = scan.nextDouble();
			bankAccount[number++] = BankAccount.getInstance(name, amount); //<-new BankAccount(name, amount); : getInstance메소드를 통해서만 객체 생성가능
			System.out.println("계좌 개설 완료");
		}
		else
			System.out.println("계좌 개설 불가");
	}
	public void deposit() { //입금
		System.out.println("---------- 입금 ----------");
		System.out.print("계좌번호 : ");
		int acc = scan.nextInt();
		BankAccount target = findAccount(acc); //입력받은 계좌번호가 존재하는 지 확인
		//만약 못 찾았다면, null값을 반환
		if(target!=null) {
			System.out.print("입금할 금액 : ");
			double amount = scan.nextDouble();
			target.deposit(amount);
		}
		else
			System.out.println("계좌 번호 확인 요함");
	}
	public void withdraw() { //출금
		System.out.println("---------- 출금 ----------");
		System.out.print("계좌번호 : ");
		int acc = scan.nextInt();
		BankAccount target = findAccount(acc);
		if(target!=null) {
			System.out.print("출금할 금액 : ");
			double amount = scan.nextDouble();
			target.withdraw(amount);
		}
		else
			System.out.println("계좌 번호 확인 요함");
	}
	public void transfer() { //이체
		System.out.println("---------- 계좌 이체 ----------");
		System.out.print("송금하는 계좌번호 : ");
		int acc1 = scan.nextInt();
		System.out.print("송금받는 계좌번호 : ");
		int acc2 = scan.nextInt();
		BankAccount target1 = findAccount(acc1);
		BankAccount target2 = findAccount(acc2);
		
		if(target1!=null && target2!=null) {
			System.out.print("이체할 금액 : ");
			double amount = scan.nextDouble();
			if(target1.getAccountBalance()>=amount) { //accountBalance의 접근제한자가 private으로 변경 : if(target1.accountBalance>=amount)변경
				//withdraw에서는 잔액을 넘어가면 출금이 되지 않음
				//but deposit에서는 조건을 걸어놓지 않았으므로 여기서 예외처리
				target1.withdraw(amount);
				target2.deposit(amount);
			}
			else
				System.out.println("출금 잔액 부족");
		}
		else
			System.out.println("계좌 번호 확인 요함");
	}
	public BankAccount findAccount(int target) { //계좌번호 찾기
		System.out.println("---------- 계좌 검색 ----------");
		if(number!=0) { //계좌가 1개 이상 개설되었을 경우
			for(int i=0;i<this.bankAccount.length;i++) { //bankAccount.length대신에 number가능
				if(bankAccount[i].getAccountNumber() == target)
					return bankAccount[i];
			}
			return null; //반복문을 돌았는데도 계좌가 없는 경우
		}
		else
			return null;
	}

	@Override
	public String toString() {
		String str = "지점명 : "+this.branchName+"\n";
		str += "----------\n";
		for(BankAccount acc : this.bankAccount) {//배열에 있는 원소들을 부르기
			if(acc!=null) { //배열엔 빈 방이 있을 수 있으므로 방이 차있을 때만 출력->처리를 안해주면 오류발생
				str += acc.toString(); //BankAccoung.java에서 override해놓은 toString
				//Q : if(acc!=null)로 조건을 달아주지 않아도 str += acc;로 변경해주면 해결가능 (null값은 null이라고 표기됨)
				//Q : if(acc!=null)로 조건을 달아주지 않아도 str += acc;로 변경해주면 해결가능 (null값은 표기되지 않음)
				//Q : BankAccount에서 toString을 override해놓아서 굳이 toString이라고 작성하지 않아도 오류없이 작동되는 것 아닌가?
				//A : 
				str += "\n";
			}
		}
		str += "----------\n";
				
		return str;
	}
	
	

}
