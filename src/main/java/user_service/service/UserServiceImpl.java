package user_service.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user_service.dto.SaveUserDto;
import user_service.dto.UserDto;
import user_service.enity.User;
import user_service.mapper.UserMapper;
import user_service.repository.cache.CacheUserRepository;
import user_service.repository.db.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final CountryService countryService;
    private final CacheUserRepository cacheUserRepository;

    @Override
    public UserDto create(SaveUserDto userDto) {
        return saveAndConvert(
                userMapper.toEntity(userDto)
                        .setCountry(countryService.get(userDto.getCountryId()))
                        .setActive(true));
    }

    @Override
    public UserDto get(long userId) {
        return cacheUserRepository.get(userId).orElseGet(() ->
                cacheUserRepository.save(userMapper.toDto(find(userId))));
    }

    @Override
    public UserDto update(long userId, SaveUserDto userDto) {
        return saveAndConvert(userMapper.update(find(userId), userDto));
    }

    @Override
    public void delete(long userId) {
        userRepository.save(find(userId)
                .setActive(false)
                .setDeleted(true)
                .setDeletedAt(LocalDateTime.now()));
        cacheUserRepository.delete(userId);
    }

    @Override
    public void subscribe(long userId, long followeeId) {
        updateFollowees(userId, followeeId, true);
    }

    @Override
    public void unSubscribe(long userId, long followeeId) {
        updateFollowees(userId, followeeId, false);
    }

    private UserDto saveAndConvert(User user) {
        return cacheUserRepository.save(userMapper.toDto(userRepository.save(user)));
    }

    private void updateFollowees(long userId, long followeeId, boolean subscribe) {
        User user = find(userId);
        User followee = find(followeeId);

        if (subscribe) {
            user.getFollowees().add(followee);
            followee.getFollowers().add(user);
        } else {
            user.getFollowees().remove(followee);
            followee.getFollowers().remove(user);
        }

        saveAndConvert(user);
        saveAndConvert(followee);
    }

    private User find(long userId) {
        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not exists"));

        if (user.isDeleted()) {
            throw new IllegalArgumentException("User with id " + userId + " was deleted");
        }

        return user;
    }
}
