package user_service.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user_service.dto.UserAuthDto;
import user_service.dto.UserCacheDto;
import user_service.mapper.UserMapper;
import user_service.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserAuthDto getUserAuth(String username) {
        return userMapper.toAuth(userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User with name " + username + " not exists")));
    }

    @Override
    public UserCacheDto getUserCache(long userId) {
        return userMapper.toUserCache(userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not exists")));
    }
}
