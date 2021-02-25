package com.chrisvz.rands.chrisvzrands.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chrisvz.rands.chrisvzrands.vo.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
	
	//@Query(value = "INSERT INTO message(from_msg,to_msg,text,created_datetime) VALUES(?1,?2,?3,now())", nativeQuery = true)
	//public int insMsg( long from, int to,String string);
	
	
@Query(value = "Select * FROM message where from_msg=?1 and to_msg=?2 or from_msg=?2 and to_msg=?1", nativeQuery = true)
public List<Message> getList( int frommsg,int tomsg);
//@Query(value = "Select * FROM message where from_msg=?2 and to_msg=?1", nativeQuery = true)
//public List<Message> getList2( int tomsg1,int frommsg2);




}