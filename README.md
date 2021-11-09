# Minimo1_LauraV_EXAMEN
Pero he creado las clases Users, Punto y ListPunto. Posteriormente se ha implementado cada función necesaria tanto en el PuntoManager como en el PuntoManagerImpl. Finalmente se ha creado el PuntoService.
He desarrollado todas las funciones pero no getusersbyname, getpuntosuser y getpuntoslist no funcionan como esperaba. 
Creo que la funcion getusersbyname se deberia hacer de la manera siguiente, pero no me ha dado tiempo a implementarla.

    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrdersByUser(@PathParam("user") String user) {
        List<User> list = scenario.getUsersbyName(user);
        if (list.size() == 0) return Response.status(404).build();

        List<User> aux = new ArrayList<User>();
        
        etc.
        
        }
