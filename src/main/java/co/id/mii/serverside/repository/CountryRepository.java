/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serverside.repository;

import co.id.mii.serverside.model.Country;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MSI-JO
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Boolean existsByName(String name);

    Optional<Country> findByName(String name);
}
