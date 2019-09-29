package com.bogdan.api;

import com.bogdan.UserDao;
import com.bogdan.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class UserApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {

        List<User> users = UserDao.getInstance().getUsersList();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(users);

        return Response
                .status(Response.Status.OK)
                .entity(result)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createNewUser(@FormParam("id") int id, @FormParam("name") String name, @FormParam("age") int age) {
        User newUser = new User(id, name, age);
        UserDao.getInstance().addUser(newUser);

        return Response
                .status(Response.Status.OK)
                .entity("User created")
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") int id) {
        String result = null;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            result = gson.toJson(UserDao.getInstance().getUser(id));
            if (result == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("There is no user with id: " + id)
                        .build();
            }
        } catch (Exception e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }
        return Response
                .status(Response.Status.OK)
                .entity(result)
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateUser(@FormParam("id") int id, @FormParam("name") String name, @FormParam("age") int age) {
        try {
            User upUser = new User(id, name, age);
            UserDao.getInstance().updateUser(upUser);
            if (UserDao.getInstance().updateUser(upUser)) {
                return Response
                        .status(Response.Status.OK)
                        .entity("User id: " + upUser.getId() + " update!")
                        .build();
            } else {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("There is no user with id: " + id)
                        .build();
            }
        } catch (Exception e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }
    }


    @DELETE
    @Path("/{name}")
    public Response delete(@PathParam("name") String name) {
        try {
            if (UserDao.getInstance().deleteUser(name)) {
                return Response
                        .status(Response.Status.OK)
                        .entity("User" + name + " deleted!")
                        .build();
            } else {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("User" + name + " not founded!")
                        .build();
            }
        } catch (Exception e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }
    }
}
