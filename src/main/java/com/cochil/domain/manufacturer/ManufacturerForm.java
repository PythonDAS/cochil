package com.cochil.domain.manufacturer;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Data
public class ManufacturerForm {

    private int nationalityCode;  // 0: 국내, 1: 해외.
    private String name;
}
