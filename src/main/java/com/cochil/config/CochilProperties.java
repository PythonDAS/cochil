package com.cochil.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@ConfigurationProperties(locations = {"classpath:/application.yml"})
@Component
@Data
public class CochilProperties {

    private Map<String, Map<String, String>> servers = new HashMap<>();
}
