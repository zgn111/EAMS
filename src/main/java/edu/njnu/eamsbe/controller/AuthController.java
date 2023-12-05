package edu.njnu.eamsbe.controller;


import edu.njnu.eamsbe.pojo.entity.User;
import edu.njnu.eamsbe.service.AuthService;
import edu.njnu.eamsbe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:5173")
public class AuthController {

    @Autowired(required = false)
    private AuthService authService;

    @PostMapping("/login")
    public Result<Boolean> login(@RequestBody User user) {
        return Result.getSuccessResult(authService.login(user));
    }

    @PostMapping("/register")
    public Result<Boolean> register(User user) {
        return Result.getSuccessResult(authService.register(user));
    }

}


