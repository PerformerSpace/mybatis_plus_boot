package com.atguitu.mybatis_plus_boot;


import com.atguitu.mybatis_plus_boot.entity.User;
import com.atguitu.mybatis_plus_boot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDTests {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("huluwa");
        user.setAge(22);
        user.setEmail("hlw@126.com");
        int insert = userMapper.insert(user);
        System.out.println("==============="+user.getId());
    }

    @Test
    public void testUpdateById(){
        User user = new User();
        user.setId(1148898113436585985L);
        user.setAge(17);
        int i = userMapper.updateById(user);

    }
}
