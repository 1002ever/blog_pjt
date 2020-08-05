package com.web.blog.dao.introduction;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.web.blog.model.introduction.Introduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntroductionDao extends JpaRepository<Introduction, String> {
    //c,u
    public Introduction save(Introduction newintro);
    //r
    public Optional<Introduction> findByIntrono(int introno);
    public List<Introduction> findByUid(String uid);
    public List<Introduction> findByStartdate(Date startdate);
    public List<Introduction> findByEnddate(Date enddate);
    public List<Introduction> findBySubjectno(int subjectNo);
    public List<Introduction> findByCompany(String company);
    //d
    public Optional<Introduction> deleteByIntrono(int introno);
}