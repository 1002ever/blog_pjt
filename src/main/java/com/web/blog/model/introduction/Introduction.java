package com.web.blog.model.introduction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Introduction {
    @Id
    @JsonIgnore
    private int introno;
    private String uid;
    private String company;
    private Date startdate;
    private Date enddate;
    private int subjectno;
    private String subject;
    private String contents;
    private int limitlength;

    // N:M을 위한 어노테이션
    @ManyToMany
    @JoinTable(name = "introduction_hashtag", 
        joinColumns = @JoinColumn(name="introduction_introno"),
        inverseJoinColumns = @JoinColumn(name = "hashtag_tagno")
    )

public String getUid() {
    return uid;
}

public void setUid(String uid) {
    this.uid = uid;
}

public String getCompany() {
    return company;
}

public void setCompany(String company) {
    this.company = company;
}

public Date getStartdate() {
    return startdate;
}

public void setStartdate(Date startdate) {
    this.startdate = startdate;
}

public Date getEnddate() {
    return enddate;
}

public void setEnddate(Date enddate) {
    this.enddate = enddate;
}

public String getSubject() {
    return subject;
}

public void setSubject(String subject) {
    this.subject = subject;
}

public String getContents() {
    return contents;
}

public void setContents(String contents) {
    this.contents = contents;
}

public int getLimitlength() {
    return limitlength;
}

public void setLimitlength(int limitlength) {
    this.limitlength = limitlength;
}

public int getIntrono() {
    return introno;
}

public void setIntrono(int introno) {
    this.introno = introno;
}

public int getSubjectno() {
    return subjectno;
}

public void setSubjectno(int subjectno) {
    this.subjectno = subjectno;
}

public Introduction(){};

@Builder
public Introduction(String uid, String company,Date startdate,Date enddate,
int subjectno,String subject,String contents,int limitlength){
    this.uid = uid;
    this.company = company;
    this.startdate = startdate;
    this.enddate = enddate;
    this.subjectno = subjectno;
    this.subject = subject;
    this.contents = contents;
    this.limitlength = limitlength;


}
@Builder
public Introduction(int introno,String uid, String company,Date startdate,Date enddate,
int subjectno,String subject,String contents,int limitlength){
    this.introno = introno;
    this.uid = uid;
    this.company = company;
    this.startdate = startdate;
    this.enddate = enddate;
    this.subjectno = subjectno;
    this.subject = subject;
    this.contents = contents;
    this.limitlength = limitlength;


}

@Override
public String toString() {
    return "Introduction [company=" + company + ", contents=" + contents + ", enddate=" + enddate + ", introno="
            + introno + ", limitlength=" + limitlength + ", startdate=" + startdate + ", subject=" + subject
            + ", subjectno=" + subjectno + ", uid=" + uid + "]";
}


}