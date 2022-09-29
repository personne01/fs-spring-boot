/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serverside.controller;

import co.id.mii.serverside.model.Country;
import co.id.mii.serverside.service.CountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MSI-JO
 */
@RestController
@RequestMapping("/country")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAll() {
        return new ResponseEntity(countryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/regionId/{id}")
    public ResponseEntity<List<Country>> findByRegionId(@PathVariable Long id) {
        return new ResponseEntity(countryService.findByRegionId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getById(@PathVariable Long id) {
        return new ResponseEntity(countryService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Country> create(@RequestBody Country country) {
        return new ResponseEntity(countryService.create(country), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> update(@PathVariable Long id, @RequestBody Country country) {
        return new ResponseEntity(countryService.update(id, country), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Country> delete(@PathVariable Long id) {
        return new ResponseEntity(countryService.delete(id), HttpStatus.OK);
    }

}
