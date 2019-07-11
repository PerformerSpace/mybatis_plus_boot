package com.atguitu.mybatis_plus_boot;

import com.atguitu.mybatis_plus_boot.entity.User;
import com.atguitu.mybatis_plus_boot.mapper.UserMapper;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusBootApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

    @Test
    public void testUpdateById(){
        User user = userMapper.selectById(1L);
        user.setAge(21);
        user.setName("lyyy111");

        //模拟另一个线程中间更新了数据
        //查询
        User user1 = userMapper.selectById(1L);
        user1.setAge(22);
        user1.setName("lyy222");
        if (userMapper.updateById(user1)==0){
            System.out.println("222222222更新失败~~~");
        }else {
            System.out.println("222222222更新成功~~~");
        }

        if (userMapper.updateById(user)==0){
            System.out.println("111111111更新失败~~~");
        }else {
            System.out.println("111111111更新成功~~~");
        }
    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println("==================="+user);
    }

    @Test
    public void test(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        users.forEach(System.out::println);
    }

}
