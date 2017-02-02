package com.micro.resources;

import com.micro.model.HealthModel;
import io.baratine.service.Service;
import io.baratine.web.Get;
import io.baratine.web.RequestWeb;

/**
 *
 * @author armdev
 */
@Service
public class CoreResource {

    // access http://127.0.0.1:9090/health-fb
    @Get("/health-fb")
    public void doFacebook(RequestWeb request) {
        HealthModel model = new HealthModel();
        model.setMessage("I am fine, Thanks!");
        model.setId(Long.MAX_VALUE);
        request.ok(model);
    }

    @Get("/health-tw")
    public void doTwitter(RequestWeb request) {
        HealthModel model = new HealthModel();
        model.setMessage("I am still #fine!!!");
        model.setId(Long.MAX_VALUE);
        request.ok(model);
    }

    @Get("/health-rocket")
    public void doRocket(RequestWeb request) {
        HealthModel model = new HealthModel();
        model.setMessage("Hello From Mars!");
        model.setId(Long.MAX_VALUE);
        request.ok(model);
    }

}
