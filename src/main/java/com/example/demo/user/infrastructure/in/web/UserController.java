package com.example.demo.user.infrastructure.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.application.ports.in.CreateUserUseCase;
import com.example.demo.user.application.ports.in.GetUserUseCase;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUser;
    private final GetUserUseCase getUser;
    private final UserWebMapper mapper;

    public UserController(
            CreateUserUseCase createUser,
            GetUserUseCase getUser,
            UserWebMapper mapper) {
        this.createUser = createUser;
        this.getUser = getUser;
        this.mapper = mapper;
    }

    @PostMapping
    public UserResponse create(@RequestBody CreateUserRequest request) {
        return mapper.toResponse(
                createUser.create(
                        request.email(),
                        request.password()
                )
        );
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return mapper.toResponse(getUser.getById(id));
    }
    
    @GetMapping("/getByMail")
    public UserResponse getByMail(@RequestParam String email) {
        return mapper.toResponse(getUser.getByMail(email));
    }
}
