package com.rubypaper.persistence;

import com.rubypaper.domain.Board;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/*
public interface BoardRepository extends CrudRepository<Board, Long> {

}
*/


public interface BoardRepository extends CrudRepository<Board, Long> {
	
	List <Board> findByTitle(String searchKeyword);
	
	///게시글 내용에 특정단어가포함된 글 목록을 조회하기 위해 
	//like 개념  ss
	List<Board> findByContentContaining(String searchKeyword);
	
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	
	/*
	@Query("SELECT b FROM b WHERE b.title like %?1% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(String searchKeyword);
	*/
}

