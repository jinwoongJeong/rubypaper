package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	
	/*
	//dataPrepare() 메소드는 테스트 메소드가 실행되기전에 동작하여 테스트에서 사용할 데이터를 셋팅함
	@Before
	public void dataPrepare() {
		for(int i=1; i<=200; i++) {
			Board board = new Board();
			board.setTitle("dtester theme"+i);
			board.setWriter("Tester");
			board.setContent("Test content " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
			
		}
	}
	*/
	
	
	/*
	@Test
	public void testFindByTitle() {
		List<Board> boardList = boardRepo.findByTitle("Tester Theme 10");
		System.out.println("검색 결과 ");
		for(Board board : boardList) {
			System.out.println("--> "+ board.toString());
		}
		
	}
	*/
	
	//like 기능하는것 
	/*
	@Test
	public void testByContentContaining() {
		List<Board> boardList = boardRepo.findByContentContaining("17");
		
		System.out.println("r검색 결과 ㄲ");
		for (Board board :boardList ) {
			System.out.println("--> "+board.toString());
		}
	}
	*/
	
	
	//페이징 기법 
	@Test
	public void testFindByTitleContaining() {
		Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
		
		
		//첫번쨰 인자 검색할 내용 두번째 인자 페이징갯수ss List<Board>타입으로 페이징 처
	//	List<Board> boardList = boardRepo.findByTitleContaining("dtester", paging);
		
		
		Page<Board> pageInfo = boardRepo.findByTitleContaining("dtester", paging);
		
		
		System.out.println("PAGE SIZE : "+pageInfo.getSize());
		System.out.println("Total PAGES : "+pageInfo.getTotalPages());
		System.out.println("TOTAL COUNT : "+pageInfo.getTotalElements());
		System.out.println("NEXT : " + pageInfo.nextPageable());
		
		List<Board> boardList = pageInfo.getContent();
		
		System.out.println("검색 결과 ");
		for(Board board : boardList) {
			System.out.println("--->"+ board.toString());
			
		}
		
	}
	

}
