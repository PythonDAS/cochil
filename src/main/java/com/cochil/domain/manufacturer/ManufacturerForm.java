package com.cochil.domain.manufacturer;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Data
public class ManufacturerForm {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    private int nationalityCode;  // 0: 국내, 1: 해외.
}