package org.acme;


import io.quarkus.security.AuthenticationFailedException;
import io.quarkus.security.UnauthorizedException;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.RoutingContext;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;

public class ExceptionMapper {

    @ServerExceptionMapper(value = AuthenticationFailedException.class, priority = Priorities.USER)
    public Uni<Response> handle(RoutingContext routingContext) {
        System.out.println("we are here AuthenticationFailedException");
        return Uni.createFrom()
                .item(Response
                        .status(401)
                        .entity("AuthenticationFailedException").build());
    }

    @ServerExceptionMapper(value = UnauthorizedException.class, priority = Priorities.USER)
    public Uni<Response> handleUnauthorized(RoutingContext routingContext){
        System.out.println("we are here UnauthorizedException");
        return Uni.createFrom()
                .item(Response
                        .status(401)
                        .entity("UnauthorizedException").build());
    }


}
