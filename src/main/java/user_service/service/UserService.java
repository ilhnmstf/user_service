package user_service.service;

import user_service.dto.SaveUserDto;
import user_service.dto.UserDto;

public interface UserService {

    UserDto create(SaveUserDto user);

    UserDto get(long userId);

    UserDto update(long userId, SaveUserDto user);

    void delete(long userId);

    void subscribe(long userId, long followeeId);

    void unSubscribe(long userId, long followeeId);
}
