package com.project.client;

import feign.Headers;
import feign.RequestLine;


@Headers("Accept: application/json")
public interface RestAPI {
    //http://howtoprogram.xyz/2016/07/18/java-rest-client-using-netflix-feign/    
    @RequestLine("GET /health-fb")
    HealthModel getHealthFb();
    
    @RequestLine("GET /health-tw")
    HealthModel getHealthTwitter();
    
    @RequestLine("GET /health-rocket")
    HealthModel getHealthRocket();
}
