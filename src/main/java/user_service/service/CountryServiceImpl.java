package user_service.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user_service.enity.Country;
import user_service.repository.db.CountryRepository;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService{
    private final CountryRepository countryRepository;

    @Override
    public long create(String title) {
        return countryRepository.save(new Country().setTitle(title)).getId();
    }

    public Country get(long countryId) {
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException("Country with id " + countryId + " not exists"));
    }
}