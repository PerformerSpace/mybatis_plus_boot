package com.atguitu.mybatis_plus_boot.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.xml.bind.annotation.XmlIDREF;
import java.util.Date;

@Data
public class User {

    //@TableId(type = IdType.ID_WORKER)//默认
    //@TableId(type = IdType.AUTO)//自增策略
    //@TableId(type = IdType.INPUT)//需要自己设置
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    private Integer version;

}
