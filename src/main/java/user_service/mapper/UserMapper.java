package user_service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import user_service.dto.SaveUserDto;
import user_service.dto.UserDto;
import user_service.enity.User;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "followers", ignore = true)
    @Mapping(target = "followees", ignore = true)
    User toEntity(SaveUserDto user);

    @Mapping(target = "followerIds", source = "followers", qualifiedByName = "toIds")
    @Mapping(target = "followeeIds", source = "followees", qualifiedByName = "toIds")
    UserDto toDto(User user);


    @Named("toIds")
    default List<Long> toIds(List<User> users) {
        return users == null || users.isEmpty() ? new ArrayList<>()
                : users.stream().map(User::getId).toList();
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "followers", ignore = true)
    @Mapping(target = "followees", ignore = true)
    User update(@MappingTarget User user, SaveUserDto userDto);
}
