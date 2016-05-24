package com.cochil.persistance;

import com.cochil.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by donghoon on 2016. 5. 22..
 */
public interface ProductRepository extends MongoRepository<Product, String> {
}
