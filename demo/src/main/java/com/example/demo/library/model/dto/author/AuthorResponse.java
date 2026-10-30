package com.example.demo.library.model.dto.author;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AuthorResponse {

    private Long id;
    private String fullname;
    private String country;
    private String birthdate;

    public AuthorResponse(Long id, String fullname, String country, String birthdate) {
        this.id = id;
        this.fullname = fullname;
        this.country = country;
        this.birthdate = birthdate;
    }
}
