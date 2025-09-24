package com.shivansh.languageManagement.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long c_id;

    @NotBlank(message = "Please Enter Country Name")
    @Size(min = 2, max = 20 , message = "The Country length must be in 2 to 20")
    private String c_name;

    private String image_name;
    private String image_type;
    @Lob
    private byte[] image;
}
