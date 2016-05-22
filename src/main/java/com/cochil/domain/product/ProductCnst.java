package com.cochil.domain.product;

/**
 * Created by donghoon on 2016. 5. 22..
 */
public enum ProductCnst {

    TOOTHPASTE(0), SHAMPOO(1);

    private final int productCode;

    ProductCnst(int code) {
        this.productCode = code;
    }
}
