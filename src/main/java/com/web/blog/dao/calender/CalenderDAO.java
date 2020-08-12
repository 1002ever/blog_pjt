package com.web.blog.dao.calender;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.web.blog.model.calender.Calender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CalenderDAO extends JpaRepository<Calender, Integer> {
   //c
   public Calender save(Calender newCalender);
   //r
   public List<Calender> findByUid(String uid);
   public Calender findByCalenderno(int calenderno);

   //u
   
	// @Modifying
	// @Query("UPDATE calender c set c.title = :title,c.content = :content,c.startdate = :startdate,c.enddate = :enddate where c.calenderno = :calenderno")
   // public void update(int calenderno, String title, String content, Date startdate, Date enddate);
   //public Optional<Calender> save()

   //d
   public void deleteByCalenderno(int calenderno);
   public void delete(Calender calender);
   
}