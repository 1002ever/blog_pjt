package com.web.blog.dao.board;

import java.util.List;
import java.util.Optional;

import com.web.blog.model.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BoardDao extends JpaRepository<Board, String> {
    public Board getBoardByBoardno(int boardno);
    @Transactional
    public Optional<Board> deleteByBoardno(int boardno);
    //@Transactional
    //public boolean deleteByBoardno(int boardno);
    public Board save(Board board);

    public List<Board> findByUid(String uid);
    public List<Board> findBySubjectLike(String subject);

    //@Query("SELECT uid FROM Board")
	//List<Board> myBoard()
}