package com.web.blog.controller.calender;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import com.web.blog.dao.calender.CalenderDAO;
import com.web.blog.dao.user.UserDao;
import com.web.blog.model.BasicResponse;
import com.web.blog.model.calender.Calender;
import com.web.blog.model.calender.CalenderRequest;
import com.web.blog.model.user.SignupRequest;
import com.web.blog.model.user.User;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@ApiResponses(value = {
    @ApiResponse(
        code = 401,
        message = "Unauthorized",
        response = BasicResponse.class
    ),
    @ApiResponse(code = 403, message = "Forbidden", response = BasicResponse.class),
    @ApiResponse(code = 404, message = "Not Found", response = BasicResponse.class),
    @ApiResponse(code = 500, message = "Failure", response = BasicResponse.class)
})

@CrossOrigin(origins = {
    "http://localhost:3000"
})
@RestController

public class CalenderController {
    @Autowired CalenderDAO dao;

    @PostMapping("/calender/create")
    @ApiOperation(value = "일정추가하기")
    public Object createCalender(@Valid @RequestBody CalenderRequest request) {
        Calender newCalender = new Calender(
            request.getUid(),
            request.getTitle(),
            request.getContent(),
            request.getStartdate(),
            request.getEnddate()
        );

        dao.save(newCalender);
        final BasicResponse result = new BasicResponse();
        result.status = true;
        result.data = "success";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/calender/{uid}")
    @ApiOperation(value = "uid로일정가져오기")
    public Object callCalender(@PathVariable String uid) {
        List<Calender> calenderList = dao.findByUid(uid);
        if (!calenderList.isEmpty()) {
            return new ResponseEntity<List<Calender>>(calenderList, HttpStatus.OK);
        } else { 
            final BasicResponse result = new BasicResponse();
            result.status = false;
            result.data = "notExist";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "/calender/{calenderno}")
    @ApiOperation(value = "calender수정하기")
    public Object modifyCalender(
        @PathVariable int calenderno,
        @Valid @RequestBody CalenderRequest request
    ) {

        Calender newCalender = new Calender(
            calenderno,
            request.getUid(),
            request.getTitle(),
            request.getContent(),
            request.getStartdate(),
            request.getEnddate()
        );
        System.out.println(dao.findByCalenderno(calenderno));
        if (dao.findByCalenderno(calenderno) != null) {
            dao.save(newCalender);
            Calender cal = dao.findByCalenderno(calenderno);
            return new ResponseEntity<Calender>(cal, HttpStatus.OK);

        } else {
            final BasicResponse result = new BasicResponse();
            result.status = false;
            result.data = "notExist";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
 

        }
    }

    @DeleteMapping("/calender/{calenderno}")
    @ApiOperation("calender삭제하기")
    public Object deleteCalender(@PathVariable int calenderno) {

        Calender calender = (Calender)dao.findByCalenderno(calenderno);
        if (calender!= null) {

            final BasicResponse result = new BasicResponse();
            result.status = true;
            result.data = "success";
            //dao.deleteByCalenderno(calenderno);
            dao.delete(calender);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            final BasicResponse result = new BasicResponse();
            result.status = false;
            result.data = "notExist";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
 

        }
    }

}