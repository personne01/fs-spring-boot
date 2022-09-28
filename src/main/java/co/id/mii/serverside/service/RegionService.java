/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serverside.service;

import co.id.mii.serverside.model.Region;
import co.id.mii.serverside.repository.RegionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author MSI-JO
 */
@Service
public class RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    public Region getById(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Region not Found"));
    }

    public Region create(Region region) {
        if (region.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region already exist");
        }
        return regionRepository.save(region);
    }

    public Region update(Long id, Region region) {
        getById(id);
        region.setId(id);
        return regionRepository.save(region);
    }

    public Region delete(Long id) {
        Region region = getById(id);
        regionRepository.delete(region);
        return region;
    }
   
}
