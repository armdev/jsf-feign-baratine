package com.beans;

import com.project.client.FeignClientInit;
import com.project.client.HealthModel;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 *
 * @author armdev
 */
@ManagedBean
@SessionScoped
public class HealthBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ManagedProperty(value = "#{feignClient}")
    private FeignClientInit feignClient;
    private HealthModel message;

    public HealthBean() {

    }

    @PostConstruct
    public void init() {       
    }

    public void doFacebook() {
      //  RestAPI restAPI = Feign.builder().encoder(new JacksonEncoder())
              //  .decoder(new JacksonDecoder()).target(RestAPI.class, "http://127.0.0.1:9090");
        message = feignClient.getRestAPI().getHealthFb();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Attention! Facebook Info: ", message.getMessage()));
    }
    
    public void doTwitter() {      
        message = feignClient.getRestAPI().getHealthTwitter();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Attention! Twitter Info: ", message.getMessage()));
    }
    
    public void doRocket() {      
        message = feignClient.getRestAPI().getHealthRocket();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Attention! Rocket Info: ", message.getMessage()));
    }

   

    public void setFeignClient(FeignClientInit feignClient) {
        this.feignClient = feignClient;
    }

}
