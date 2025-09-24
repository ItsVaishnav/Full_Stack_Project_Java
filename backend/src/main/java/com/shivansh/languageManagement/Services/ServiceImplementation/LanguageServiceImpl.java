package com.shivansh.languageManagement.Services.ServiceImplementation;

import com.shivansh.languageManagement.DTO.LanguageDTO;
import com.shivansh.languageManagement.Entity.Language;
import com.shivansh.languageManagement.Exception.ResourceNotFoundException;
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

    private final LanguageRepository languageRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<LanguageDTO> getLanguages() {
        List<Language>  languages = languageRepository.findAll();
        List<LanguageDTO>  languageDTOS = languages
                .stream()
                .map(language -> modelMapper.map(language,LanguageDTO.class)).toList();
        return languageDTOS;
    }

    @Override
    public LanguageDTO createLanguages(LanguageDTO languageDTO) {
        Language language = modelMapper.map(languageDTO,Language.class);
        return modelMapper.map(languageRepository.save(language),LanguageDTO.class);
    }

    @Override
    public String deleteLanguageById(Long id) {
        if(!languageRepository.existsById(id)){
            throw new ResourceNotFoundException("Language does not exist");
        }
        languageRepository.deleteById(id);
        return "Language has been deleted with id: "+id;
    }

    @Override
    public LanguageDTO updateById(Long id, LanguageDTO languageDTO) {
        Language language = languageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Language does not exist with id: "+id));
        languageDTO.setId(id);
        modelMapper.map(languageDTO,language);
        return modelMapper.map(languageRepository.save(language),LanguageDTO.class);
    }


}
