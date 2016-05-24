package com.cochil.service.manufacturer;

import com.cochil.domain.manufacturer.Manufacturer;
import com.cochil.persistance.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by donghoon on 2016. 5. 24..
 */
@Service
public class ManufacturerService implements IManufacturerService {

    @Autowired
    private ManufacturerRepository repository;

    /**
     * mongodb save 함수는 upsert 로 동작한다.
     *
     * @param manufacturer
     */
    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        if (manufacturer == null)
            throw new NullPointerException("manufacturer is null...");

        return repository.save(manufacturer);
    }

    @Override
    public Page<Manufacturer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Long count() {
        return repository.count();
    }
}