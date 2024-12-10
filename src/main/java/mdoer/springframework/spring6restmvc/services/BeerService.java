package mdoer.springframework.spring6restmvc.services;

import mdoer.springframework.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    Beer findBeerById(UUID id);
    List<Beer> findAllBeers();

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);

}
