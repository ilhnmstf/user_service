package user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import user_service.enity.Role;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAuthDto {
    private String username;
    private String password;
    private Set<Role> roles;
}
