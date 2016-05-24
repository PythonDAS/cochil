package com.cochil.persistance;

import com.cochil.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}