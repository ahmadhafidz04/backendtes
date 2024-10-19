package com.exercise.listingservice.service;

import com.exercise.listingservice.dto.*;

public interface UserService {

    GetUsersResponseDto getUsers(GetUsersRequestDto requestDto);

    GetSpesificUserResponseDto getUser(GetUsersResponseDto requestDto, Long id);

    CreateUserResponseDto createUser(CreateUserRequestDto requestDto);
}
