package user_service.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import user_service.dto.UserAuthDto;
import user_service.dto.UserCacheDto;

@Validated
public interface UserController { //TODO CREATE DOC

    ResponseEntity<UserCacheDto> getUserCacheForFeed(@Min(value = 1, message = "should more than 0") long userId);

    ResponseEntity<UserAuthDto> getUserAuth(@NotBlank String username);
}
