package com.exercise.listingservice.controller;

import com.exercise.listingservice.dto.GetListingsResponseDto;
import com.exercise.listingservice.entity.User;
import com.exercise.listingservice.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Valid
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(
            @RequestParam(name = "pageNum", defaultValue = "1") @Min(1) Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "10") @Min(1) Integer pageSize,
            @RequestParam(name = "Id", required = false) @Min(1) Integer Id
    ) {
        GetUsersResponseDto requestDto = new GetUsersResponseDto();
    }
}
