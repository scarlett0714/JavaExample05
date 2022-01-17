//객체 배열 만들기 연습
package tptty.example02;

import java.util.Scanner;

class Book {
	String title, author;
	public Book(String title, String author) { //생성자
		this.title = title;
		this.author = author;
	}
}
public class BookArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Book[] book = new Book[2]; //객체 배열 선언 : Book을 가리킬 수 있는 빈 방 2개
		
		for(int i=0;i<book.length;i++) {
			System.out.print("제목>>");
			String title = scanner.nextLine();
			System.out.print("저자>>");
			String author = scanner.nextLine();
			book[i] = new Book(title, author); //배열 원소 객체 생성
		}
		
		scanner.close();
		
		for(int i=0;i<book.length;i++)
			System.out.print("("+book[i].title+","+book[i].author+")");
	}

}
