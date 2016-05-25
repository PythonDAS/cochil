package com.cochil.service.product;

import com.cochil.domain.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by donghoon on 2016. 5. 24..
 */
public interface IProductService {
    Product save(Product ingredient);

    Page<Product> findAll(Pageable pageable);

    Long count();
}
