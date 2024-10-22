package com.exercise.listingservice.service;

import com.exercise.listingservice.dto.*;

public interface UserService {

    GetUsersResponseDto getUsers(GetUsersRequestDto requestDto);

    GetSpecificUserResponseDto getUser(GetSpecificUserRequestDto requestDto);

    CreateUserResponseDto createUser(CreateUserRequestDto requestDto);
}
