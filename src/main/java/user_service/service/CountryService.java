package user_service.service;

import user_service.enity.Country;

public interface CountryService {

    long create(String title);

    Country get(long countryId);
}