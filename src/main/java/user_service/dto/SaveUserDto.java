package user_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SaveUserDto {
    @NotBlank(message = "should not be null or empty")
    private String username;

    @NotBlank(message = "should not be null or empty")
    private String password;

    @NotBlank(message = "should not be null or empty")
    private String email;

    private String phone;

    private String aboutMe;

    private String city;

    @Min(value = 1, message = "should be more than 0")
    private long countryId;
}