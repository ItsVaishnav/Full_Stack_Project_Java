package com.shivansh.languageManagement.Controller;

import com.shivansh.languageManagement.DTO.LanguageDTO;
import com.shivansh.languageManagement.Services.LanguageServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("lang/")
public class LanguageController {
    LanguageServices languageServices;
@GetMapping("/")
    public ResponseEntity<List<LanguageDTO>> getAllLanguages(){
        return ResponseEntity.ok(languageServices.getLanguages());
    }
}
