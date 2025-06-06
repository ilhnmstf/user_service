package user_service.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface CountryController {

    ResponseEntity<Long> create(@RequestParam @Valid String country);
}