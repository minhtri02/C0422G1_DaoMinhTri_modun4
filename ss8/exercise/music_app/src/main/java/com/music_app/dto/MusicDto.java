package com.music_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MusicDto implements Validator {

    private Integer id;

    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^([A-Za-z ])+$")
    private String nameMusic;

    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^(([A-Z][a-z]+\\s?){1,5})$")
    private String singer;

    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^([A-Za-z ,]+)$")
    private String kind;

    public MusicDto(String nameMusic, String singer, String kind) {
        this.nameMusic = nameMusic;
        this.singer = singer;
        this.kind = kind;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
