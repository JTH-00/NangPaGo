package com.mars.common.dto.user;

import com.mars.common.model.user.User;
import lombok.Builder;

@Builder
public record UserResponseDto(
    String email,
    String nickname,
    String role,
    String password
) {

    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
            .email(user.getEmail())
            .nickname(user.getNickname())
            .role(user.getRole())
            .build();
    }

    public static UserResponseDto adminFrom(User user){
        return UserResponseDto.builder()
            .email(user.getEmail())
            .nickname(user.getNickname())
            .role(user.getRole())
            .password(user.getPassword())
            .build();
    }
}
