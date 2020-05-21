package com.kk.mapper;

import com.kk.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper//当前的接口，是mybatis的mapper层接口
public interface UserMapper {
    User findById(@Param("id") Integer id);

    List<User> findAll();
}
