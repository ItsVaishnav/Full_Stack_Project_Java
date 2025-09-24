package com.shivansh.languageManagement.Services;

import com.shivansh.languageManagement.DTO.LanguageDTO;

import java.util.List;

public interface LanguageServices {
    List<LanguageDTO> getLanguages();

    LanguageDTO createLanguages(LanguageDTO languageDTO);

    String deleteLanguageById(Long id);

    LanguageDTO updateById(Long id, LanguageDTO languageDTO);
}
