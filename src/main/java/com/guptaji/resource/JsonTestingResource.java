package com.guptaji.resource;

import com.guptaji.entity.GenericJsonTestingEntity;
import com.guptaji.repository.JsonTestingRepo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jsonTesting")
public class JsonTestingResource {

    @Inject
    public JsonTestingRepo jsonTestingRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDetails(){
        return Response.ok(jsonTestingRepo.listAll()).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertAuthorDetails(GenericJsonTestingEntity genericJsonTestingEntity){
        jsonTestingRepo.persist(genericJsonTestingEntity);
        if (jsonTestingRepo.isPersistent(genericJsonTestingEntity)){
            return Response.ok("Done dana done done").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
