package com.web.blog.dao.introduction;

import com.web.blog.model.introduction.HashTag;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagDao extends JpaRepository<HashTag, String>{

    // create
    public HashTag save(HashTag newtag);

    // select 
    public int findHashtagByTagno(String tagname);

}