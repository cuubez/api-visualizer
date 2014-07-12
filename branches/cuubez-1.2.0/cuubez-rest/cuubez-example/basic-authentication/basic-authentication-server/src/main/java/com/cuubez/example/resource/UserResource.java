/**
 *	Copyright [2013] [www.cuubez.com]
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.cuubez.example.resource;

import com.cuubez.core.annotation.security.DenyAll;
import com.cuubez.core.annotation.security.PermitAll;
import com.cuubez.core.annotation.security.RolesAllowed;
import com.cuubez.example.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users/{userId}")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private static Log log = LogFactory.getLog(UserResource.class);


    @PermitAll
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response userGet(@HeaderParam(value = "name") String name, @PathParam(value = "userId") String id, @QueryParam(value = "age") Double age) {

        User user = new User(id, age, name);
        return Response.ok().entity(user).build();
    }

    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public void userPost(User user) {
        log.info("POST = [" + user + "]");
    }

    @DenyAll
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void userPut(User user) {
        log.info("PUT = [" + user + "]");

    }

}
