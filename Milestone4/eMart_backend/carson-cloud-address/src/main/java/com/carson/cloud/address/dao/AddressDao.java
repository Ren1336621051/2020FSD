package com.carson.cloud.address.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carson.cloud.address.entity.AddressEntity;


@Repository
public interface AddressDao extends JpaRepository<AddressEntity, Integer>{

	@Transactional
	@Query(value = "select address.s_address a where a.user_id=?",nativeQuery = true)
	public List<AddressEntity> findByUser(Integer id);

	@Transactional
	@Query(value = "insert into address.s_address (id,address,user_id,crtDate)"
			+ "values(#{id},#{address},#{user_id},#{crtDate})",nativeQuery = true)
	public void add(AddressEntity user);

	@Transactional
	@Query(value = "select address.s_address a where a.id=?",nativeQuery = true)
	public AddressEntity findById(String id);
	
	@Modifying
	@Transactional
	@Query(value = "update address.s_address a set a.address=? where u.id=?",nativeQuery = true)
	public void updateAddress(@Param("address")String address,@Param("id")Integer id);

	@Transactional
	@Query(value = "delete from address.s_address a where a.id=?",nativeQuery = true)
	public void deleteAddress(@Param("id")Integer id);
	
}
