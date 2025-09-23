package com.shivansh.languageManagement.Services.ServiceImplementation;

import com.shivansh.languageManagement.DTO.LanguageDTO;
import com.shivansh.languageManagement.Entity.Language;
import com.shivansh.languageManagement.Repository.LanguageRepository;
import com.shivansh.languageManagement.Services.LanguageServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageServices {

    LanguageRepository  languageRepository;
    ModelMapper modelMapper;
    @Override
    public List<LanguageDTO> getLanguages() {
        List<Language>  languages = languageRepository.findAll();
        List<LanguageDTO>  languageDTOS = languages
                .stream()
                .map(language -> modelMapper.map(language,LanguageDTO.class)).toList();
        return languageDTOS;
    }
}
