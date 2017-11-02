package com.garyhu;

import java.io.InputStream;

import java.util.List;

import com.garyhu.mapper.CategoryMapper;

import com.garyhu.pojo.Category;
import com.garyhu.pojo.CategoryExample;
import com.garyhu.mapper.CategoryMapper;
import com.garyhu.pojo.CategoryExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class TestMybatis {
    public static void main(String args[]) throws Exception {
        System.out.println("先运行TestMybatisGenerator创建mapper,pojo,xml 等文件，然后取消import里被注释的，以及接下来的注释，并执行代码");


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
        CategoryExample example = new CategoryExample();
        example.createCriteria().andNameLike("%1%");
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
        List<Category> cs= mapper.selectByExample(example);
        for (Category c : cs) {
            System.out.println(c.getName());
        }


    }
}
