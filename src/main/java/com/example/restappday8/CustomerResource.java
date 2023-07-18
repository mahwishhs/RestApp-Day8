package com.example.restappday8;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/customers")
public class CustomerResource {
    private CustomerCRUD customerCRUD;

    public CustomerResource() {
        this.customerCRUD = new CustomerCRUD();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers() {
        return Response.ok(customerCRUD.getAllCustomers()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerById(@PathParam("id") int id) {
        Customer customer = customerCRUD.getCustomerById(id);
        if (customer != null) {
            return Response.ok(customer).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/name")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomersByName(@QueryParam("name") String name) {
        List<Customer> customersByName = customerCRUD.getCustomersByName(name);
        if (!customersByName.isEmpty()) {
            return Response.ok(customersByName).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCustomer(Customer customer) {
        customerCRUD.saveCustomer(customer);
        return Response.ok(customerCRUD.getAllCustomers()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCustomer(@PathParam("id") int id, Customer customer) {
        customerCRUD.updateCustomer(id, customer);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") int id) {
        customerCRUD.deleteCustomer(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
