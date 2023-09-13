package com.iukme.common.dto;

import lombok.Data;

@Data
public class PageDTO {

    private Integer size = 1;

    private Integer current = 20;
}
