package edu.njnu.eamsbe;

import edu.njnu.eamsbe.mapper.AuthMapper;
import edu.njnu.eamsbe.pojo.entity.User;
import edu.njnu.eamsbe.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
class EamsBeApplicationTests {


    @Autowired(required = false)
    private AuthService authService;
    @Autowired(required = false)
    private AuthMapper authMapper;

    @Test
    void contextLoads() {

    }

    @Test
    public void test() {
        User user = new User();
        user.setUsername("123abc");
        user.setPassword("123abc1");
//        System.out.println(authService.login(user));
        List<User> result = authMapper.findLoginUser(user);
        System.out.println(result);

    }

}
