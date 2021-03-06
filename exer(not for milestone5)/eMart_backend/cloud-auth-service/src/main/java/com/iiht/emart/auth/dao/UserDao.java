package com.iiht.emart.auth.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iiht.emart.auth.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer>{
	
	public UserEntity findById(Integer id);
	
	@Transactional
	@Query(value = "select * from s_user u where u.user_name=?",nativeQuery = true)
	public UserEntity findUserByUserName(String userName);
	
	@Modifying
	@Transactional
	@Query(value = "update s_user u set u.conformed='1' where u.id=?",nativeQuery = true)
	public int activeUser(@Param("id")Integer id);
}
