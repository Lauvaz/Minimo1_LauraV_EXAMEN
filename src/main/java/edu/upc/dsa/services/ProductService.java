package edu.upc.dsa.services;


import edu.upc.dsa.PuntoManager;
import edu.upc.dsa.PuntoManagerImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/Products", description = "Endpoint to Track Service")
@Path("/Products")
public class ProductService {

    private PuntoManager scenario;

    public ProductService() {
        scenario = PuntoManagerImpl.getInstance();
        scenario.addPunto(new Punto("puente", 1));
        scenario.addPunto(new Punto("puerta", 2));
        scenario.addPunto(new Punto("escalera", 3));


        scenario.addUser("Laura", "111");
        scenario.addUser("Anna", "222");

        ListPuntos addpuntos = new ListPuntos(scenario.getUser("Laura"));
        addpuntos.addPunto(new Punto("escalera", 2));

    }


    @POST
    @ApiOperation(value = "Add a new user", notes = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {

        if (user.getName()==null || user.getId()==null || user.getPuntosList()==null) return Response.status(500).entity(user).build();
        this.scenario.addUser(user.getName(), user.getId());
        return Response.status(201).entity(user).build()  ;

    }

    @POST
    @ApiOperation(value = "Add a new punto", notes = "Add a new punto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Punto.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/addPunto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Punto punto) {

        if (punto.getName()==null || punto.getAmount()==0 ) return Response.status(500).entity(punto).build();
        this.scenario.addPunto(punto);
        return Response.status(201).entity(punto).build()  ;

    }

    @GET
    @ApiOperation(value = "Get Users by Name", notes = "Get Users by Name")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Products not found")
    })
    @Path("/GetUsersbyName/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersbyName() {
        List<User> list = scenario.getUsersbyName();
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(list) {};
        if (list.size() == 0) return Response.status(404).build();
        return Response.status(201).entity(entity).build();
    }


    @GET
    @ApiOperation(value = "Get puntos by User", notes = "Get punto by User")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = ListPuntos.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Products not found")
    })
    @Path("/GetPuntosUser/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPuntosUser(User user) {
        List<ListPuntos> list = scenario.getPuntosUser(user);
        GenericEntity<List<ListPuntos>> entity = new GenericEntity<List<ListPuntos>>(list) {};
        if (list.size() == 0) return Response.status(404).build();
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "Get puntos List", notes = "Get puntos List")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = ListPuntos.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Products not found")
    })
    @Path("/GetPuntosList/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPuntosList() {
        List<ListPuntos> list = scenario.getPuntosList();
        GenericEntity<List<ListPuntos>> entity = new GenericEntity<List<ListPuntos>>(list) {};
        if (list.size() == 0) return Response.status(404).build();
        return Response.status(201).entity(entity).build();
    }

 }