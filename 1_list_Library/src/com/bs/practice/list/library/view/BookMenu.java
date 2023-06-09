package com.bs.practice.list.library.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.bs.practice.list.library.controller.BookController;
import com.bs.practice.list.library.model.vo.Book;

public class BookMenu {
	
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	
//	사용자가 직접 메인 메뉴를 선택할 수 있음.
//	종료 전까지 반복 실행. 각 메뉴를 누를 시 해당 메소드로 이동.
	public void mainMenu() {
		while(true) {
			System.out.println("**** 메인 메뉴 ****");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int choice = sc.nextInt();
			switch(choice) {
				case 1 : insertBook(); break;
				case 2 : selectList(); break;
				case 3 : searchBook(); break;
				case 4 : deleteBook(); break;
				case 5 : ascBook(); break;
				case 9 : System.out.println("프로그램을 종료합니다."); return;
				default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요."); break;
			}
		}
	}
	
//	도서 추가를 위해 정보를 받는 메소드
	public void insertBook() {
		System.out.println("**** 새 도서 추가 ****");
		System.out.println("책 정보를 입력해주세요.");
		System.out.print("도서 명 : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("저자 명 : ");
		String author = sc.nextLine();
		System.out.print("장르(1. 인문 / 2. 과학 / 3. 외국어 / 4. 기타) : ");
		int category = sc.nextInt();
		String cate = null;
		if(category == 1) {
			cate = "인문";
		} else if(category == 2) {
			cate = "과학";
		} else if(category == 3) {
			cate = "외국어";
		} else if(category == 4) {
			cate = "기타";
		}
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		bc.insertBook(new Book(title, author, cate, price));
	
	}
	
//	전체 도서 목록 출력 성공을 알리는 메소드
	public void selectList() {
		System.out.println("**** 도서 전체 조회 ****");
		ArrayList<Book> booklist = bc.selectList();
		
		if(booklist.isEmpty()) {
			System.out.println("존재하는 도서가 없습니다.");
		} else {
			for(Book b : booklist) {
				System.out.println(b);
			}
		}
	}
	
//	특정 도서 검색 결과를 보여주는 메소드
	public void searchBook() {
//		1. 검색할 도서명 키워드로 입력 받기 (String keyword) 
		System.out.println("**** 도서 검색 ****");
		System.out.print("검색 키워드 : ");
		sc.nextLine();
		String keyword = sc.nextLine();
		ArrayList<Book> searchList = bc.searchBook(keyword);
		if(searchList.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for(Book b : searchList) {
				System.out.println(b);
			}
		}
//		** 결과 값이 한 도서의 Book 객체가 아니라 리스트인 이유
//		 보통 프로그램에서 검색 할 때 풀 네임을 쳐서 검색하지 않고 키워드로 검색
//		 즉, 키워드를 포함한 결과가 하나가 아닌 여러 개일 수 있기 때문에 리스트로 받기
	}
	
//	특정 도서 삭제 성공을 알리는 메소드
	public void deleteBook() {
		System.out.println("**** 도서 삭제 ****");
		System.out.print("삭제할 도서 명 : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("삭제할 저자 명 : ");
		String author = sc.nextLine();
		Book remove = bc.deleteBook(title, author);
		if(remove == null) {
			System.out.println("삭제할 도서를 찾지 못했습니다.");
		} else {
			System.out.println("성공적으로 삭제되었습니다.");
		}
	}
	
//	책 명 오름차순 정렬 성공을 알리는 메소드
	public void ascBook() {
		if(bc.ascBook() == 1) {
			System.out.println("정렬에 성공하였습니다.");
		} else {
			System.out.println("정렬에 실패하였습니다.");
		}
	}
	
}
