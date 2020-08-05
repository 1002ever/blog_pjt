package com.web.blog.model.board;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Board {
    @Id
    int boardno;
    String uid;
    String subject;
    int likes;
    String content;
    String interest;
    String picture;
    String date;

    public int getBoardno() {
        return this.boardno;
    }

    public void setBoardno(int boardno) {
        this.boardno = boardno;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInterest() {
        return this.interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return "boardno : " + this.boardno + "\nsubject : " + this.subject + "\ndate : " + this.date + "\ninterest : " + this.interest
        + "\nlike : " + this.likes + "\nuid : " + this.uid + "\ncontent : " + this.content;
    }

}