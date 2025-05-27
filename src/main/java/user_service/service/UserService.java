package user_service.service;

import user_service.dto.UserAuthDto;
import user_service.dto.UserCacheDto;

public interface UserService {

    UserAuthDto getUserAuth(String username);

    UserCacheDto getUserCache(long userId);
}
