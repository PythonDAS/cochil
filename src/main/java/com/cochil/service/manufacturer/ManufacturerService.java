package com.cochil.service.manufacturer;

import com.cochil.domain.manufacturer.Manufacturer;
import com.cochil.persistance.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by donghoon on 2016. 5. 24..
 */
public class ManufacturerService implements IManufacturerService {

    @Autowired
    private ManufacturerRepository repository;

    /**
     * mongodb save 함수는 upsert 로 동작한다.
     *
     * @param manufacturer
     */
    @Override
    public void save(Manufacturer manufacturer) {
        if (manufacturer == null)
            throw new NullPointerException("manufacturer is null...");

        repository.save(manufacturer);
    }

    @Override
    public Page<Manufacturer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}