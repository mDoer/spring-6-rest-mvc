package mdoer.springframework.spring6restmvc.services;

import lombok.extern.slf4j.Slf4j;
import mdoer.springframework.spring6restmvc.model.Beer;
import mdoer.springframework.spring6restmvc.model.BeerStyle;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer findBeerById(UUID id) {

        log.debug("findBeerById was called with parameter" + id);
        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Beer")
                .beerStyle(BeerStyle.ALE)
                .upc("XYZ")
                .build();
    }
}
