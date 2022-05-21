package test.jlt.jlt_web;

import com.jlt.jlt_webstu.model.domain.User;
import com.jlt.jlt_webstu.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class selectForConditionTest {
    public static void main(String[] args) throws IOException {

        String resource = "src/main/resources/mapper/UserMapper.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);



        List<User> list =mapper.selectForCondition("金林涛","0");

        System.out.println(list);


    }
}
