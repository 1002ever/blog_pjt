package com.web.blog.controller.introduction;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.web.blog.dao.introduction.HashTagDao;
import com.web.blog.dao.introduction.IntroductionDao;
import com.web.blog.model.BasicResponse;
import com.web.blog.model.introduction.HashTag;
import com.web.blog.model.introduction.Introduction;
import com.web.blog.model.introduction.Tagging;
import com.web.blog.model.introduction.WriteRequest;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized", response = BasicResponse.class),
        @ApiResponse(code = 403, message = "Forbidden", response = BasicResponse.class),
        @ApiResponse(code = 404, message = "Not Found", response = BasicResponse.class),
        @ApiResponse(code = 500, message = "Failure", response = BasicResponse.class) })

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class IntroductionController {

    @Autowired
    IntroductionDao introDao;

    @Autowired
    HashTagDao tagDao;


    // 1. 자소서 작성
    @PostMapping("/introduction/create")
    @ApiOperation(value = "자소서작성")
    public Object createIntro(@Valid @RequestBody WriteRequest request) {
        ResponseEntity response = null;

        store(request);

        final BasicResponse result = new BasicResponse();
        result.status = true;
        result.data = "success";

        response = new ResponseEntity<>(result, HttpStatus.OK);

        return response;
    }

    // 자소서 & 해시태그 동시 저장
    @Transactional
    public void store(WriteRequest data) {
        Introduction newIntro = data.getIntroduction();
        HashTag newTag = data.getHashTag();
        newTag.setCnt(1);
        System.out.println(newTag.toString());

        // 이미 등록되어 있는 해시태그 들어오면, count +1
        HashTag oldTag = tagDao.findHashtagByTagname(newTag.getTagname());
        if (oldTag != null) {
            oldTag.setCnt(oldTag.getCnt() + 1);
            newTag = oldTag;
        }

        Tagging newTagging = new Tagging();
        newTagging.setIntroduction(newIntro);
        newTagging.setHashtag(newTag);
        newIntro.addTagging(newTagging);
        
        tagDao.save(newTag);
        introDao.save(newIntro);
    }


    // 2. 자소서 수정
    // 2.2 변경된 내용을 찾아서 자소서 수정을 저장하는 부분
    @PutMapping("/introduction/{introno}")
    @ApiOperation(value = "자소서수정")
    public Object updateIntro(@PathVariable int introno, @Valid @RequestBody WriteRequest request) {
        ResponseEntity response = null;
        Introduction intro = request.getIntroduction();
        HashTag tag = request.getHashTag();

        intro.setIntrono(introno);
        introDao.save(intro);

        // 해시태그 수정해야함.....
        final BasicResponse result = new BasicResponse();
        result.status = true;
        result.data = "success";

        response = new ResponseEntity<>(result, HttpStatus.OK);

        return response;
    }

    // 3. 자소서 삭제
    @DeleteMapping("/introduction/{introno}")
    @ApiOperation(value = "자소서삭제")
    public Object deleteIntro(@PathVariable int introno) {
        ResponseEntity response = null;

        introDao.deleteByIntrono(introno);

        final BasicResponse result = new BasicResponse();
        result.status = true;
        result.data = "success";

        response = new ResponseEntity<>(result, HttpStatus.OK);

        return response;

    }

    // 4. 자소서 불러오기(하나만 불러오기)
    @GetMapping("/introduction/{introno}")
    @ApiOperation(value = "introno로자소서보기")
    public Object callIntro(@PathVariable int introno) {
        Introduction intro = introDao.findByIntrono(introno);
        return intro;

    }

    @GetMapping("/introduction/uid/{uid}")
    @ApiOperation(value = "uid로자소서보기")
    public ResponseEntity<List<Introduction>> callIntrobyUid(@PathVariable String uid) {
        List<Introduction> list = introDao.findByUid(uid);

        return new ResponseEntity<List<Introduction>>(list, HttpStatus.OK);

    }

    @GetMapping("/introduction/startdate/{startdate}")
    @ApiOperation(value = "startdate로자소서보기")
    public ResponseEntity<List<Introduction>> callIntrobyStartdate(@PathVariable Date startdate) {
        List<Introduction> list = introDao.findByStartdate(startdate);
        return new ResponseEntity<List<Introduction>>(list, HttpStatus.OK);

    }

    @GetMapping("/introduction/enddate/{enddate}")
    @ApiOperation(value = "enddate로자소서보기")
    public ResponseEntity<List<Introduction>> callIntrobyEnddate(@PathVariable Date enddate) {
        List<Introduction> list = introDao.findByEnddate(enddate);
        return new ResponseEntity<List<Introduction>>(list, HttpStatus.OK);

    }

    @GetMapping("/introduction/company/{company}")
    @ApiOperation(value = "company로자소서보기")
    public ResponseEntity<List<Introduction>> callIntrobyCompany(@PathVariable String company) {
        List<Introduction> list = introDao.findByCompany(company);
        return new ResponseEntity<List<Introduction>>(list, HttpStatus.OK);

    }
}