package org.acme;

import io.smallrye.mutiny.Uni;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
@ApplicationScoped
public class Hello {

    @GET
    @Path("hello")
    @RolesAllowed({"roleINeed"})
    public Uni<Response> hello() {
        return Uni.createFrom().item(Response.ok("hello").build());
    }
}
