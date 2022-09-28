/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serverside.controller;

import co.id.mii.serverside.model.Region;
import co.id.mii.serverside.service.RegionService;
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
@RequestMapping("/region")
public class RegionController {

    private RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public ResponseEntity<List<Region>> getAll() {
        return new ResponseEntity(regionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Region> getById(@PathVariable Long id) {
        return new ResponseEntity(regionService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Region> create(@RequestBody Region region) {
        return new ResponseEntity(regionService.create(region), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> update(@PathVariable Long id, @RequestBody Region region) {
        return new ResponseEntity(regionService.update(id, region), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Region> delete(@PathVariable Long id) {
        return new ResponseEntity(regionService.delete(id), HttpStatus.OK);
    }
}
