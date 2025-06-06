package user_service.repository.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;
import user_service.dto.UserDto;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RedisUserRepository implements CacheUserRepository {
    private final HashOperations<String, Long, UserDto> userHashOperations;
    private final String key = "user";


    @Override
    public UserDto save(UserDto user) {
        CompletableFuture.runAsync(() -> {
            log.debug("Try to save value '{}' to key {}:{} to redis", user, key, user.getId());
            userHashOperations.put(key, user.getId(), user);
        }); // todo add pool
        return user;
    }

    @Override
    public Optional<UserDto> get(long userId) {
        log.debug("Try to get value in key {}:{} in redis", key, userId);
        return Optional.ofNullable(userHashOperations.get(key, userId));
    }

    @Override
    public void delete(long userId) {
        log.debug("Try to delete value in key {}:{} in redis", key, userId);
        userHashOperations.delete(key, userId);
    }
}