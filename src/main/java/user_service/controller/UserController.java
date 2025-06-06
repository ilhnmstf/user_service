package user_service.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import user_service.dto.SaveUserDto;
import user_service.dto.UserDto;

@Validated
public interface UserController { //TODO CREATE DOC

    ResponseEntity<UserDto> create(@RequestBody @Valid SaveUserDto user);

    ResponseEntity<UserDto> get(
            @PathVariable @Min(value = 1, message = "should more than 0") long userId);

    ResponseEntity<UserDto> update(
            @PathVariable @Min(value = 1, message = "should more than 0") long userId,
            @RequestBody @Valid SaveUserDto user);

    ResponseEntity<Void> delete(
            @PathVariable @Min(value = 1, message = "should more than 0") long userId);

    ResponseEntity<Void> subscribe(
            @PathVariable @Min(value = 1, message = "should more than 0") long userId,
            @RequestParam @Min(value = 1, message = "should more than 0") long followeeId);

    ResponseEntity<Void> unSubscribe(
            @PathVariable @Min(value = 1, message = "should more than 0") long userId,
            @RequestParam @Min(value = 1, message = "should more than 0") long followeeId);
}
