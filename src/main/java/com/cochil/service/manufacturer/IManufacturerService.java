package com.cochil.service.manufacturer;

import com.cochil.domain.manufacturer.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by donghoon on 2016. 5. 24..
 */
public interface IManufacturerService {
    Manufacturer save(Manufacturer ingredient);

    Page<Manufacturer> findAll(Pageable pageable);

    Long count();
}
