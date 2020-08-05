package com.web.blog.model.calender;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Calender {
    @Id
    int calenderno;
    
    @JsonIgnore
    String uid;
    String title;
    String content;
    Date startdate;
    Date enddate;

    public int getCalenderno() {
        return calenderno;
    }

    public void setCalenderno(int calenderno) {
        this.calenderno = calenderno;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Builder
    public Calender(){}
    @Builder
    public Calender(String uid,String title, String content, Date startdate,Date enddate){
        this.uid = uid;
        this.title = title;
        this.content = content;
        this.startdate = startdate;
        this.enddate = enddate;
        
    }
    @Builder
    public Calender(int calenderno,String uid,String title, String content, Date startdate,Date enddate){
        this.calenderno = calenderno;
        this.uid = uid;
        this.title = title;
        this.content = content;
        this.startdate = startdate;
        this.enddate = enddate;
        
    }
}