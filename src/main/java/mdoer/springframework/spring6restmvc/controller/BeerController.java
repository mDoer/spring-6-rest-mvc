package mdoer.springframework.spring6restmvc.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mdoer.springframework.spring6restmvc.model.Beer;
import mdoer.springframework.spring6restmvc.services.BeerService;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@AllArgsConstructor
@Controller
@Slf4j
public class BeerController {

    private final BeerService beerService;

    public Beer getBeerByID(UUID id) {
        log.debug("getBeerByID - in controller");
        return beerService.findBeerById(id);
    }

}
