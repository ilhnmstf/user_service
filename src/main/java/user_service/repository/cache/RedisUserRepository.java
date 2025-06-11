package user_service.repository.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import user_service.dto.UserDto;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Repository
@Slf4j
public class RedisUserRepository implements CacheUserRepository {
    private final UserRedisOptimisticOperation userRedisOptimisticOperation;
    private final HashOperations<String, Long, UserDto> userHashOperations;
    private final ExecutorService saveUserPool;
    private final String key;

    @Autowired
    public RedisUserRepository(RedisTemplate<String, UserDto> userRedisTemplate,
                               UserRedisOptimisticOperation userRedisOptimisticOperation,
                               ExecutorService saveUserPool) {
        this.userRedisOptimisticOperation = userRedisOptimisticOperation;
        userHashOperations = userRedisTemplate.opsForHash();
        this.saveUserPool = saveUserPool;
        key = "user";
    }


    @Override
    public UserDto saveOptimistic(UserDto user) {
        CompletableFuture.runAsync(() ->
                userRedisOptimisticOperation.saveOptimistic(key + ":" + user.getId(),
                        () -> userHashOperations.put(key, user.getId(), user)), saveUserPool);
        return user;
    }

    @Override
    public Optional<UserDto> get(long userId) {
        UserDto user = userHashOperations.get(key, userId);
        log.info("Get value {} in key {}:{} in redis", user, key, userId);
        return Optional.ofNullable(user);
    }

    @Override
    public void delete(long userId) {
        userHashOperations.delete(key, userId);
        log.info("Delete key {}:{} in redis", key, userId);
    }
}