package com.shivansh.languageManagement.Repository;

import com.shivansh.languageManagement.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
