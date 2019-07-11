package com.atguitu.mybatis_plus_boot;

import com.atguitu.mybatis_plus_boot.entity.User;
import com.atguitu.mybatis_plus_boot.mapper.UserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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
        User user = userMapper.selectById(1148898323130785795L);
        System.out.println("==================="+user);
    }

    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        users.forEach(System.out::println);
    }
    @Test
    public void testSelectByMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","Tom");
        map.put("age","28");

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectPage(){
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testSelectMapsPage(){
        Page<User> page = new Page<>(1,5);
        IPage<Map<String, Object>> iPage = userMapper.selectMapsPage(page, null);
        iPage.getRecords().forEach(System.out::println);

        //注意：此行必须使用 mapIPage 获取记录列表，否则会有数据类型转换错误
        System.out.println(page.getCurrent());


        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testDeleteById(){
        int i = userMapper.deleteById(1148898323130785795L);
        System.out.println(i);

    }
    @Test
    public void testDeleteBatchIds(){
        userMapper.deleteBatchIds(Arrays.asList(1L,2L));
    }


}
