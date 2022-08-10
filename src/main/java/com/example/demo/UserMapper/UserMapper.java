package com.example.demo.UserMapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.beans.Transient;
import java.util.List;
@Mapper
public interface UserMapper {
    @Select("select * from usertable")
    List<User> findAll();

    @Options(useGeneratedKeys = true,keyProperty = "uid")
    @Insert("INSERT INTO usertable (username,password) VALUES (#{username}, #{password});")
    @Transactional
    void save(User user);

    @Select("select username from usertable where uid = #{uid}")
    User select_uid(Integer uid);

    @Select("select * from usertable where username = #{username}")
    User select_username(String username);

    @Update("UPDATE usertable set password = #{password} where username = #{username}")
    void setPassword(User user);
}
