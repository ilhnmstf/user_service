package user_service.controller;

import org.springframework.http.ResponseEntity;
import user_service.dto.UserAuthDto;
import user_service.dto.UserCacheDto;

public interface UserController { //TODO CREATE DOC

    ResponseEntity<UserCacheDto> getUserCacheForFeed(long userId);

    ResponseEntity<UserAuthDto> getUserAuth(String username);
}
