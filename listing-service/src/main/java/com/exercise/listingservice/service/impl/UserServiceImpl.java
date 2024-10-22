package com.exercise.listingservice.service.impl;

import com.exercise.listingservice.dto.*;
import com.exercise.listingservice.entity.User;
import com.exercise.listingservice.repository.ListingRepository;
import com.exercise.listingservice.repository.UserRepository;
import com.exercise.listingservice.service.UserService;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public GetUsersResponseDto getUsers(GetUsersRequestDto requestDto) {
        PageRequest pageRequest = PageRequest.of(requestDto.getPageNum(),
                requestDto.getPageSize(), Sort.by("createAt").descending()
        );

        List<User> result = Optional.ofNullable(requestDto.getId())
                .map(id -> userRepository.findById(id, pageRequest))
                .orElseGet(() -> userRepository.findAll(pageRequest).getContent());

        List<UserDto> userDtoList = result.stream()
                .map(this::convertUsertoUserDto)
                .collect(Collectors.toList());

        GetUsersResponseDto responseDto = new GetUsersResponseDto();
        responseDto.setResult(true);
        responseDto.setUsers(userDtoList);

        return responseDto;
    }

    @Override
    public GetSpecificUserResponseDto getUser(GetSpecificUserRequestDto requestDto) {
        List<User> result;

        if (requestDto.getId() != null) {
            Optional<User> userOptional = userRepository.findById(requestDto.getId());
            result = userOptional.map(List::of).orElseGet(List::of);
        } else {
            PageRequest pageRequest = PageRequest.of(requestDto.getPageNum(),
                    requestDto.getPageSize(), Sort.by("createAt").descending());
            result = userRepository.findAll(pageRequest).getContent();
        }
        List<UserDto> userDtoList = result.stream()
                .map(this::convertUsertoUserDto)
                .collect(Collectors.toList());

        GetSpecificUserResponseDto responseDto = new GetSpecificUserResponseDto();
        responseDto.setResult(true);
        responseDto.setUser(userDtoList);

        return responseDto;
    }

    @Override
    public CreateUserResponseDto createUser(CreateUserRequestDto requestDto) {
        User user = new User();
        user.setName(requestDto.getName());

        final Long timestamp = nowInEpochMicroSeconds();
        user.setCreateAt(timestamp);
        user.setUpdateAt(timestamp);

        userRepository.save(user);

        CreateUserResponseDto responseDto = new CreateUserResponseDto();
        responseDto.setResult(true);
        responseDto.setUser(convertUsertoUserDto(user));

        return responseDto;
    }

    private UserDto convertUsertoUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        return userDto;
    }

    private Long nowInEpochMicroSeconds() {
        return ChronoUnit.MICROS.between(Instant.EPOCH, Instant.now());
    }
}
