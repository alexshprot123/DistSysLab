package lab.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import lab.jdbc.ControllerJDBC;
import lab.jdbc.entitys.Item;

import java.util.List;

@Path("/jdbc")
public class RestJDBC {

    @Inject
    ControllerJDBC controller;

    @GET
    public List<Item> getALL() {
        return controller.getAllItems();
    }

    @POST
    public String addItem(Item item) {
        return controller.addItem(item) ? "Предмет добавлен" : "Произошла ошибка";
    }

    @PUT
    public String changeItem(Item item) {
        return controller.updateItem(item) ? "Предмет изменён" : "Произошла ошибка";
    }

    @DELETE
    @Path("/{id}")
    public String deleteItem(@PathParam("id") long id) {
        return controller.deleteItem(id) ? "Предмет удалён" : "Произошла ошибка";
    }
}
