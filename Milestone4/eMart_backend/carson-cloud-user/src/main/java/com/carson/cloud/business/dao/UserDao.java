package com.carson.cloud.business.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carson.cloud.business.entity.UserEntity;



@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer>{

	public static final EntityManager entityManager = null;
	
	Date  date =new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
	String date1 = sdf.format(date);
	
	@Transactional
	@Query(value = "select * from user.s_user s where s.user_name=?",nativeQuery = true)
	public UserEntity findByName(String username);
	
	@Transactional 
	@Query(value = "select * from user.s_user s where s.user_id=?",nativeQuery = true)
	public UserEntity findById(String id);

	@Transactional
	@Query(value = "insert into s_user (id,username,password,usertype,email,mobileNum,crtDate)"
			+ "values(#{id},#{username},#{password},#{usertype},#{email},#{mobileNum},#{crtDate})",nativeQuery = true)
	public void registUser(UserEntity user);
	
	@Modifying
	@Transactional
	@Query(value = "update s_user u set u.password=? where u.username=?",nativeQuery = true)
	public void updatePassword(@Param("password")String password,@Param("username")String username);

	
//	@Modifying
//	@Transactional
//	@Query(value = "update s_user u set u.conformed='1' where u.id=?",nativeQuery = true)
//	public int activeUser(@Param("id")Integer id);
	
}
