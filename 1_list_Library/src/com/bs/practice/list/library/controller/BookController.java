package com.bs.practice.list.library.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.bs.practice.list.library.model.vo.Book;

public class BookController {
	
	List list = new ArrayList();
	
//	초기 값을 넣어줄 기본 생성자
	public BookController() {
		list.add(new Book("자바의 정석", "남궁 성", "기타", 20000));
		list.add(new Book("쉽게 배우는 알고리즘", "문병로", "기타", 15000));
		list.add(new Book("대화의 기술", "강보람", "인문", 17500));
		list.add(new Book("암 정복기", "박신우", "의료", 21000));
	}
	
//	리스트에 값 저장 메소드
	public void insertBook(Book bk) {
		list.add(bk);
	}
	
//	모든 리스트를 출력하는 메소드
	public ArrayList selectList() {
		return (ArrayList) list;
	}
	
//	키워드로 책을 검색하는 메소드
	public ArrayList searchBook(String keyword) {
		// 검색 결과 리스트를 담아줄 리스트(ArrayList searchList) 선언 및 생성
		// 반복문을 통해 list의 책 중 책 명에 전달 받은 keyword가 포함되어있는 경우
		// searchList에 해당 책 추가하고 searchList 반환
		ArrayList searchList = new ArrayList();
		for(int i = 0; i < list.size(); i++) {
			Book b = (Book)list.get(i);
			if(b.getTitle().contains(keyword)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;
		
	}
	
//	책 제목과 저자 명으로 책을 삭제하는 메소드
	public Book deleteBook(String title, String author) {
		// 삭제된 도서를 담을 Book객체 (Book removeBook) 선언 및 null로 초기화
		// 반복문을 통해 bookList의 책 중 책 명이 전달 받은 title과 동일하고
		// 저자 명이 전달 받은 author와 동일한 경우 해당 인덱스 도서 삭제 후 빠져나감
		// 이 때 해당 인덱스 도서를 removeBook에 대입 후 removeBook 반환
		Book removeBook = null;
		
		for(int i = 0; i < list.size(); i++) {
			Book b = (Book)list.get(i);
			if(b.getTitle().equals(title) && b.getAuthor().equals(author)) {
				removeBook = (Book) list.remove(i);
			}
		}
		return removeBook;
	}
	
//	책 명 오름차순 정렬하는 메소드
	public int ascBook() {
		Collections.sort(list);
		return 1;
	}
}
