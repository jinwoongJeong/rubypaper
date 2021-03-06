package com.rubypaper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMappingTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	
	/*
	@Test
	public void testManyToOneInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPassword("member111");
		member1.setName("dullie");
		member1.setRole("User");
		memberRepo.save(member1);
		
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setPassword("member222");
		member2.setName("dauner");
		member2.setRole("Admin");
		memberRepo.save(member2);
		
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			board.setMember(member1);
			board.setTitle("둘리가 등록하 게시글"+i);
			board.setContent("둘리가 등록한 게시글 내용"+i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
		
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			board.setMember(member2);
			board.setTitle("도우너가 등록한 게시글"+i);
			board.setContent("도우너가 등록한 게시글 내용 " +i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
		*/
	
	@Test
	public void testManyToOneSelect() {
		Board board = boardRepo.findById(5L).get();
		System.out.println("["+board.getSeq()+"번 게글 정보 ]");
		System.out.println("제목 : "+board.getTitle());
		System.out.println("내용 : "+board.getContent());
		System.out.println("작성자 : "+board.getMember().getName());
		System.out.println("작성자권한 : "+board.getMember().getRole());
		
		
	}
	

}
