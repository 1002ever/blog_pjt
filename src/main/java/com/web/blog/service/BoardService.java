package com.web.blog.service;

import java.util.List;
import java.util.Optional;

import com.web.blog.dao.board.BoardDao;
import com.web.blog.model.board.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    BoardDao boardDao;

    public List<Board> getListOfBoard() {
        return boardDao.findAll();
    }

    public Board getBoard(int boardno) {
        return boardDao.getBoardByBoardno(boardno);
    }

    public Optional<Board> deleteBoard(int boardno) {
        return boardDao.deleteByBoardno(boardno);
    }

    public Board createBoard(Board board) {
        return boardDao.save(board);
    }

    public Board updateBoard(Board board) {
        return boardDao.save(board);
    }
    
    public List<Board> findByUid(String uid) {
        return boardDao.findByUid(uid);
    }

    public List<Board> findBySubject(String subject) {
        return boardDao.findBySubjectLike(subject);
    }

    
    // 페이지네이션
    public Page<Board> findBoardByPageRequest(Integer page){
        PageRequest pageRequest = PageRequest.of(page, 10);
        System.out.println(boardDao.findAll(pageRequest));
        return boardDao.findAll(pageRequest);

    }

}
