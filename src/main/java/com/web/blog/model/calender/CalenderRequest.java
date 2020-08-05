package com.web.blog.model.calender;
  
import java.sql.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@Valid
@ToString
public class CalenderRequest {
    @ApiModelProperty(required = true)
    int calenderno;
    @ApiModelProperty(required = true)
    @NotNull 
    String uid;
    @ApiModelProperty(required = true)
    @NotNull 
    String title;
    @ApiModelProperty(required = true)
    @NotNull 
    String content;
    @ApiModelProperty(required = true)
    @NotNull 
    Date startdate;
    @ApiModelProperty(required = true)
    @NotNull 
    Date enddate;

    public int getCalenderno() {
        return calenderno;
    }

    public void setCalenderno(int calenderno) {
        this.calenderno = calenderno;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    
}