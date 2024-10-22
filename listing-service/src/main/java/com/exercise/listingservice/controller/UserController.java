package com.exercise.listingservice.controller;

import com.exercise.listingservice.dto.*;
import com.exercise.listingservice.dto.GetUsersRequestDto;
import com.exercise.listingservice.dto.GetUsersResponseDto;
import com.exercise.listingservice.dto.GetSpecificUserRequestDto;
import com.exercise.listingservice.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public GetUsersResponseDto getUsers(
            @RequestParam(name = "pageNum", defaultValue = "1") @Min(1) Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "10") @Min(1) Integer pageSize,
            @RequestParam(name = "Id", required = false) @Min(1) Integer Id
    ) {
        GetUsersRequestDto requestDto = new GetUsersRequestDto();
        requestDto.setPageNum(pageNum - 1);
        requestDto.setPageSize(pageSize);
        requestDto.setId(Id);

        return userService.getUsers(requestDto);
    }

    @GetMapping("/users/{Id}")
    public GetSpecificUserResponseDto getUser(
            @RequestParam(name = "Id", required = false) @Min(1) Integer Id
    ) {
        GetSpecificUserRequestDto requestDto = new GetSpecificUserRequestDto();
        requestDto.setId(Id);
        return userService.getUser(requestDto);
    }
    @PostMapping
    public CreateUserResponseDto createUser(@Valid CreateUserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }
}
