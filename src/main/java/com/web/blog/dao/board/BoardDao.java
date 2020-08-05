package com.web.blog.dao.board;

import java.util.List;

import com.web.blog.model.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDao extends JpaRepository<Board, String> {
    Board getBoardByBoardno(int boardno);
    boolean deleteByBoardno(int boardno);
    Board save(Board board);

    List<Board> findByUid(String uid);
    List<Board> findBySubjectLike(String subject);
}