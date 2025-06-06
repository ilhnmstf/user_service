package user_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user_service.service.CountryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/countries")
public class CountryControllerImpl implements CountryController {
    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<Long> create(String title) {
        return ResponseEntity.ok().body(countryService.create(title));
    }
}