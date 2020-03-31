package com.example.demo.test.dao;

import com.example.demo.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = "select * from  user_db p where p.name= ?1", nativeQuery = true)
    public List<User> findByName(String name);
//
//    @Query(value = "select p from  Person p where p.name=:name and p.address=:address")
//    public List<User> withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    @Modifying
    @Query(value = "select * from  user_db", nativeQuery = true)
    public List<User> getAllUser();

    @Modifying
    @Query(value = "delete from  User  p where p.name= ?1")
    public int deleteByName(@Param("name") String name);

    @Modifying
    @Query(value = "insert into user_db(name,age) value(?1,?2)", nativeQuery = true)
    public int Add(String name, String age);

    @Modifying
    @Query(value = "update user_db set name=?2 where name =?1", nativeQuery = true)
    public int modify(String oldName, String newName);
}
