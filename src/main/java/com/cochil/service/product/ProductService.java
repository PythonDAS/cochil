package com.cochil.service.product;

import com.cochil.domain.product.Product;
import com.cochil.persistance.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by donghoon on 2016. 5. 24..
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;

    /**
     * mongodb save 함수는 upsert 로 동작한다.
     *
     * @param product
     */
    @Override
    public Product save(Product product) {
        if (product == null)
            throw new NullPointerException("product is null...");

        return repository.save(product);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Long count() {
        return repository.count();
    }
}
