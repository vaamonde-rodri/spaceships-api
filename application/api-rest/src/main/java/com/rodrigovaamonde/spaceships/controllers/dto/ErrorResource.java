package com.rodrigovaamonde.spaceships.controllers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResource {
    private String code;
    private String description;
    private List<String> details;
}
