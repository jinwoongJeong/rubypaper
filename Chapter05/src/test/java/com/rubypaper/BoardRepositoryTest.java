package com.rubypaper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	//출력했지만 나오지 않ddd
	/*
	@Test
	public void testGetBoard() {
		Board board = boardRepo.findById(1L).get();
		System.out.println(board.toString());
	}
	*/
	
	
	/*
	@Test
	public void testUpdateBoard() {
		System.out.println("==== 1 rpwlwl filter");
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("==== 1 dfdfdsf chaning theme ");
		board.setTitle("제목을 수정했습니다. ");
		boardRepo.save(board);
	}
	*/
	
	@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(1L);
	}
	
	
	//입력//
	/*
	@Test
	public void testInsertBoard() {
		Board board = new Board();
		board.setTitle("첫번재 께시글 ");
		board.setWriter("testtter");
		board.setContent("wkf rigsiterrr??");
		board.setCnt(0L);
		board.setCreateDate(new Date());
		
		boardRepo.save(board);
		
		
	}
	*/
	


}
