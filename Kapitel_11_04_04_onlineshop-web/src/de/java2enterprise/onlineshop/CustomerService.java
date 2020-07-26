package de.java2enterprise.onlineshop;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.java2enterprise.onlineshop.ejb.RegisterBean;
import de.java2enterprise.onlineshop.model.Customer;

@Path("customer")
public class CustomerService {
    
    @EJB
    RegisterBean registerBean;

    @POST
    @Path("persist")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer persist(
        @FormParam("email") String email,
        @FormParam("password") String password) {

        return registerBean.persist(email, password);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer find(@PathParam("id") Long id) {       
        return registerBean.find(id);
    }
}
