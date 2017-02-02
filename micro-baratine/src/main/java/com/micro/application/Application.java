package com.micro.application;

import com.micro.resources.CoreResource;
import io.baratine.web.Web;

/**
 *
 * @author Admin
 */
public class Application {

    public static void main(String[] args) throws Exception {
        Web.include(CoreResource.class);
        Web.scanAutoConf();
        Web.port(9090);
        Web.property("json.jackson.enabled", "true");   
        Web.go(args);
    }
}
