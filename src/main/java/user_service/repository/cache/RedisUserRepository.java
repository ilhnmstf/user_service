package user_service.repository.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import user_service.dto.UserDto;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Repository
@Slf4j
public class RedisUserRepository implements CacheUserRepository {
    private final UserRedisOptimisticOperation userRedisOptimisticOperation;
    private final HashOperations<String, Long, UserDto> userHashOperations;
    private final String key;

    @Autowired
    public RedisUserRepository(RedisTemplate<String, UserDto> userRedisTemplate) {
        userRedisOptimisticOperation = new UserRedisOptimisticOperation(userRedisTemplate);
        userHashOperations = userRedisTemplate.opsForHash();
        key = "user";
    }


    @Override
    public UserDto saveOptimistic(UserDto user) {
        CompletableFuture.runAsync(() ->
                userRedisOptimisticOperation.saveOptimistic(key + ":" + user.getId(),
                        () -> userHashOperations.put(key, user.getId(), user))); // todo add pool

        return user;
    }

    @Override
    public Optional<UserDto> get(long userId) {
        log.info("Get value in key {}:{} in redis", key, userId);
        return Optional.ofNullable(userHashOperations.get(key, userId));
    }

    @Override
    public void delete(long userId) {
        log.info("Delete value in key {}:{} in redis", key, userId);
        userHashOperations.delete(key, userId);
    }
}