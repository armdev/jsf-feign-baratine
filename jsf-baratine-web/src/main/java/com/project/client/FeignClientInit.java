package com.project.client;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author armenar
 */
@ManagedBean(name = "feignClient", eager = false)
@ApplicationScoped
public class FeignClientInit {
    
    private final RestAPI restAPI;    

    public FeignClientInit() {
        restAPI = Feign.builder().encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder()).target(RestAPI.class, "http://127.0.0.1:9090");
    }   

    public RestAPI getRestAPI() {
        return restAPI;
    }

    

}
