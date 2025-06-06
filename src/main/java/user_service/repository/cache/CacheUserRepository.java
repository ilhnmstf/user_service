package user_service.repository.cache;

import user_service.dto.UserDto;

import java.util.Optional;

public interface CacheUserRepository {

    UserDto save(UserDto user);

    Optional<UserDto> get(long userId);

    void delete(long userId);
}