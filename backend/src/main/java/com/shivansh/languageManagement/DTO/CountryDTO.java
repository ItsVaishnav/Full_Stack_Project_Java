package com.shivansh.languageManagement.DTO;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {

    private Long c_id;
    private String c_name;

//    TO Store the image
    private String image_name;
    private String image_type;
    @Lob  // This is to specify the object is very long
    private byte[] image;
}
