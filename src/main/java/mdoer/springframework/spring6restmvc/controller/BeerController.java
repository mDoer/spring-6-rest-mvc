package mdoer.springframework.spring6restmvc.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mdoer.springframework.spring6restmvc.model.Beer;
import mdoer.springframework.spring6restmvc.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
@Slf4j
public class BeerController {

    private final BeerService beerService;


    @PutMapping("{beerId}")
    public ResponseEntity<Beer> updateById(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer) {

        beerService.updateBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    // @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody Beer beer) {
        Beer savedBeer = beerService.saveNewBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Beer getBeerByID(@PathVariable("beerId") UUID beerId) {
        log.debug("getBeerByID - in controller 1234 ");
        return beerService.findBeerById(beerId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> getAllBeers() {
        log.debug("getAllBeers - in controller");
        return beerService.findAllBeers();
    }

}
