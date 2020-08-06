package com.web.blog.controller.board;

import java.util.List;
import java.util.Optional;

import com.web.blog.model.BasicResponse;
import com.web.blog.model.board.Board;
import com.web.blog.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;

@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized", response = BasicResponse.class),
        @ApiResponse(code = 403, message = "Forbidden", response = BasicResponse.class),
        @ApiResponse(code = 404, message = "Not Found", response = BasicResponse.class),
        @ApiResponse(code = 500, message = "Failure", response = BasicResponse.class) })

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api/board")
public class BoardController {
    
    @Autowired
    private BoardService boardService;
    
    @ApiOperation(value = "모든 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping("/listAll")
	public ResponseEntity<List<Board>> getListOfBoard() throws Exception {
        List<Board> list = boardService.getListOfBoard();

        for(Board b : list) {
            System.out.println(b.toString());
        }
		return new ResponseEntity<List<Board>>(boardService.getListOfBoard(), HttpStatus.OK);
    }
    
    @ApiOperation(value = "특정 게시글의 정보를 반환한다.", response = Board.class)
    @GetMapping("/boardno/{boardno}")
    public ResponseEntity<Board> getBoard(@PathVariable int boardno) throws Exception {
        Board board = boardService.getBoard(boardno);

        System.out.println(board.toString());

        if(board == null)
            return new ResponseEntity<Board>(board, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Board>(board, HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 작성자로 찾기", response = Board.class)
    @GetMapping("/uid/{uid}")
    public ResponseEntity <List<Board>> getBoardByUid(@PathVariable String uid) throws Exception {
        List<Board> boardList = boardService.findByUid(uid);

        if(boardList.size()==0)
            return new ResponseEntity<List<Board>>(boardList, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 제목으로 찾기", response = Board.class)
    @GetMapping("/subject/{subject}")
    public ResponseEntity<List<Board>> getBoardBySubject(@PathVariable String subject) throws Exception {
        System.out.println(subject);
        List<Board> boardList = boardService.findBySubject(subject);

        if(boardList.size()==0)
            return new ResponseEntity<List<Board>>(boardList, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
    }

    @ApiOperation(value = "특정 게시글을 삭제한다.", response = Board.class)
    @DeleteMapping("/{boardno}")
    public ResponseEntity<Board> deleteBoard(@PathVariable int boardno) throws Exception {
        System.out.println("Delete board" + boardno + " in--------------------------");

        Optional<Board> isDeleted = boardService.deleteBoard(boardno);
        System.out.println("delete board ......");

        if(!isDeleted.isEmpty())
            return new ResponseEntity(HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    
    @ApiOperation(value = "새로운 게시글을 생성한다.", response = String.class)
    @PostMapping("/create")
    public ResponseEntity<String> createBoard(@RequestBody Board board) throws Exception {
        System.out.println("in");
		if (boardService.createBoard(board) != null) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "특정 게시글을 수정한다.", response = Board.class)
    @PutMapping("/{boardno}")
    public ResponseEntity<String> updateBoard(@RequestBody Board board) throws Exception {
        
		if (boardService.updateBoard(board) != null) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "페이지 네이션")
    @GetMapping("/paging")
    public ResponseEntity<Page<Board>> findBoardByPageRequest(@RequestParam Integer page){

        Page<Board> board = null;
        if(page == -1){
            page = 0;
            board = boardService.findBoardByPageRequest(page);
        }

        else{
            board = boardService.findBoardByPageRequest(page);
        }
        if(board == null)
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

   
}