package user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class UserDto {
    private long id;
    private List<Long> followeeIds;
    private List<Long> followerIds;
}
