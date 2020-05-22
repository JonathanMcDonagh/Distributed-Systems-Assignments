/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Cars;
import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jonathan McDonagh / 20074520
 * Assignment 4
 * Distributed Systems
 * 
 */
@Stateless
@Path("entities.cars")
public class CarsFacadeREST extends AbstractFacade<Cars> {

    @PersistenceContext(unitName = "carsDB_20074520PU")
    private EntityManager em;

    public CarsFacadeREST() {
        super(Cars.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cars entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Cars entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    /* Get by ID */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cars find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    /* Get by CarID and Year */
    @GET
    @Path("findByCarIdAndYear/{carID}/{cYear}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cars findByCarIdAndYear(@PathParam("carID") int i, @PathParam("cYear") int y) {
        return super.findByCarIdAndYear(i, y);
    }

    /* Get by Make and Model */
    @GET
    @Path("findByMakeAndModel/{cMake}/{cModel}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Override
    public Cars findByMakeAndModel(@PathParam("cMake") String make, @PathParam("cModel") String model) {
        return super.findByMakeAndModel(make, model);
    }
    
    /* Get by Make */
    @GET
    @Path("/make/{cMake}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cars make(@PathParam("cMake") String c) {
        return super.findMake(c);
    }
 
    /* Get by Model */
    @GET
    @Path("/model/{cModel}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cars model(@PathParam("cModel") String c) {
        return super.findModel(c);
    }
    
    /* Get by Year */
    @GET
    @Path("/year/{cYear}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cars year(@PathParam("cYear") int c) {
        return super.findYear(c);
    }

    /* Get all */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cars> findAll() {
        return super.findAll();
    }

    /* Get from and to */    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cars> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /* Get count */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
