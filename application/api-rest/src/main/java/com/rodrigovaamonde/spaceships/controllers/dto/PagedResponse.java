package com.rodrigovaamonde.spaceships.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PagedResponse<T> {
    private List<T> data;
    private int page;
    private int totalPages;
    private long totalElements;

}
