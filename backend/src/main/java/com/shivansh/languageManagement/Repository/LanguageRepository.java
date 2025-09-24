package com.shivansh.languageManagement.Repository;

import com.shivansh.languageManagement.Entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Long> {

}
