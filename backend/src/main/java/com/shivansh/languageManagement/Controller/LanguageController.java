package com.shivansh.languageManagement.Controller;

import com.shivansh.languageManagement.DTO.LanguageDTO;
import com.shivansh.languageManagement.Services.LanguageServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("lang/")
@CrossOrigin(origins = "http://localhost:5173")
public class LanguageController {

    private final LanguageServices languageServices;


    @GetMapping("/")
    public ResponseEntity<List<LanguageDTO>> getAllLanguages(){
        return ResponseEntity.ok(languageServices.getLanguages());
    }

    @PostMapping("/")
    public ResponseEntity<LanguageDTO> createLanguage(@RequestBody LanguageDTO languageDTO){
        return ResponseEntity.ok(languageServices.createLanguages(languageDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLanguageById(@PathVariable Long id){
        return ResponseEntity.ok(languageServices.deleteLanguageById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageDTO> updateLanguageById(@PathVariable Long id, @RequestBody LanguageDTO languageDTO){
        return ResponseEntity.ok(languageServices.updateById(id,languageDTO));
    }
}
