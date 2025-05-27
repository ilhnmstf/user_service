package user_service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import user_service.dto.UserAuthDto;
import user_service.dto.UserCacheDto;
import user_service.enity.Role;
import user_service.enity.User;
import user_service.enity.UserRole;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "followerIds", expression = "java(UserMapper.toIds(user.getFollowers()))")
    @Mapping(target = "followeeIds", expression = "java(UserMapper.toIds(user.getFollowees()))")
    UserCacheDto toUserCache(User user);

    @Mapping(target = "roles", expression = "java(UserMapper.toRoles(user.getRoles()))")
    UserAuthDto toAuth(User user);

    static List<Long> toIds(List<User> users) {
        return users.stream().map(User::getId).toList();
    }

    static Set<Role> toRoles(Set<UserRole> roles) {
        return roles.stream().map(UserRole::getRole).collect(Collectors.toSet());
    }
}
