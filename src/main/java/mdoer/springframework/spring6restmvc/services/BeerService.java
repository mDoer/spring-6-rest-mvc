package mdoer.springframework.spring6restmvc.services;

import mdoer.springframework.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer findBeerById(UUID id);
}
