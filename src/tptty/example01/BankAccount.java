package tptty.example01;

public class BankAccount {
	
	//접근제한자는 원래 public으로 해도 정상작동, 새로운 예시를 위해 private으로 변경->BankManager.java에서 오류발생
	private static int count = 0;
	private int accountNumber; //계좌번호
	private String customerName; //고객이름
	private double accountBalance; //잔액

	//인스턴스 초기화 블록
	{
		this.accountNumber = ++count; //객체가 생성될 때마다, 객체가 모두 공유하는 static변수 count 값 변경
	}
	
	//디폴트 생성자가 필요없다면 생성하지 않아도 괜찮
	//오버로드 생성자 생성
	//accountNumber의 경우 모든 생성자에서 사용되므로,
	//1. 객체 생성 시 자동으로 배정(모든 생성자에서 공통으로 수행) -> 초기화 블록사용
	//2. 객체 생성 시 자동으로 랜덤배정(모든 생성자에서 공통으로 수행) -> 모든 객체들이 공유해서 사용할 변수 필요 (static int count)
	
//	public BankAccount(int accountNumber, String customerName) { 
//		this.accountNumber = accountNumber; //더 이상 계좌번호를 입력받을 필요x
//		this.customerName = customerName;
//	} -> 아래와 같이 변경
	private BankAccount(String customerName) { //기존 public에서 다른 클래스에서 객체 생성하지 못하도록 생성자를 private으로 변경
//		super(); //\부모 (BackAccount클래스가 생성될 때, Object클래스(부모클래스)에서 생성됨 -> Object클래스의 디폴트생성자를 가져오겠다라는 의미)
		this(customerName, 0.0); //아래의 생성자 호출
	}


//	public BankAccount(int accountNumber, String customerName, double accountBalance) { 
//		this.accountNumber = accountNumber;
//		this.customerName = customerName;
//		this.accountBalance = accountBalance;
//	} ->아래와 같이 변경
	private BankAccount(String customerName, double accountBalance) { //public->private
//		super();
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}
	
	//메소드
	public void deposit(double amount) { //입금
		this.accountBalance += amount;
	}
	public void withdraw(double amount) { //출금
		if(this.accountBalance>=amount) {
			this.accountBalance -= amount;
		}
		else
			System.out.println("출금 잔액 부족");
		
	}
	public void transfer(BankAccount account, double amount) { //이체
		if(this.accountBalance>=amount) {
			this.withdraw(amount); //내 계좌에서는 출금
			account.deposit(amount); //상대 계좌에서는 입금
		}
		else
			System.out.println("이체 불가");
	}

	//A.
	//[Source]->[Override/Implement Methods..]->[Object :부모를 지정하지 않으면 자동으로 Object에서 파생된 클래스가 생성]->[toString]
	@Override //Object(부모)클래스에서 정의해놓은 함수 재정의
	public String toString() {
		
		String str = "고객이름 : "+ this.customerName;
		str += "\n계좌번호 : "+ this.accountNumber;
		str += "\n잔액 : " + this.accountBalance;
		
		//return super.toString(); //Object에서 이루어졌던 것 : super.toString : 인수의 참조값(주소값)을 문자열로 출력 ->변경
		return str;
	}

	//P : 필드의 접근제한자를 public->private으로 지정하면 다른 클래스인 BankManager에서 필드를 사용할 수 없음
	//S : [Source]->[Generate Getters and Setters..]->선택->[Sort by] : getter와 setter을 한번에/getter정의 후 setter정의->[접근제한자]
	//BankManager클래스에서 해당 부분을 get, set함수로 변경
	
	
	public static int getCount() {
		return count;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public String getCustomerName() {
		return customerName;
	}


	public double getAccountBalance() {
		return accountBalance;
	}

	//밖에서 count값 변경x->set함수 지우기
//	public static void setCount(int count) {
//		BankAccount.count = count;
//	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

//BankManager클래스에서 생성자 BankAccount를 사용하기 위해 getInstance메소드 생성
	public static BankAccount getInstance(String name, double amount) { //따로 객체를 생성하지 않아야함 : static
		
		return new BankAccount(name, amount); //생성자 사용가능(위에서는 private이라 BankManager에서 사용x)
	}
	
	
	
}
