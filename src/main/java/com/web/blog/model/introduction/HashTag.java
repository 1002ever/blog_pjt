package com.web.blog.model.introduction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="hashtag")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HashTag {

    @Id
    @JsonIgnore
    @Column(name = "tagno")
    private int tagno;

    @Column(name = "tagname")
    private String tagname;
    @Column(name= "count")
    private int count;

    // @ManyToMany(mappedBy = "introduction")
    // private ArrayList<Introduction> intro = new ArrayList<>();

    public HashTag(){};

    public int getTagno() {
        return tagno;
    }

    public void setTagno(int tagno) {
        this.tagno = tagno;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Builder
    public HashTag(String tagname, int count) {
        this.tagname = tagname;
        this.count = count;
    }

    @Override
    public String toString() {
        return "HashTag [count=" + count + ", tagname=" + tagname + ", tagno=" + tagno + "]";
    }
    
}