package com.shivansh.languageManagement.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("lang/")
@CrossOrigin(origins = "http://localhost:5173")
public class CountryController {

}
