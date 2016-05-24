package com.cochil.domain.manufacturer;

/**
 * Created by donghoon on 2016. 5. 24..
 */
public enum ManufacturerCnst {

    DOMESTIC(0), FOREIGN(1);

    private final int manufacturerCode;

    ManufacturerCnst(int code) {
        this.manufacturerCode = code;
    }
}
