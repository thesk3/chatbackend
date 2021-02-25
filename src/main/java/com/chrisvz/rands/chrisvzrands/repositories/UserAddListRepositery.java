package com.chrisvz.rands.chrisvzrands.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chrisvz.rands.chrisvzrands.vo.UserAdd;


public interface UserAddListRepositery extends JpaRepository<UserAdd, Long> {

	@Query(value = "SELECT * FROM user_chat_list WHERE user_id= ?1", nativeQuery = true)
	public List<UserAdd> findByIdCust(long cid);
}
