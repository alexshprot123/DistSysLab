package lab.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import lab.db.JDBCService;

import lab.db.entity.Item;

import java.util.List;

@Path("/jdbc")
public class JDBCController {

    @Inject
    JDBCService jdbcService;

    @GET
    public List<Item> getALL() {
        return jdbcService.getAllItems();
    }

    @POST
    public String addItem(Item item) {
        return jdbcService.addItem(item) ? "Предмет добавлен" : "Произошла ошибка";
    }

    @PUT
    public String changeItem(Item item) {
        return jdbcService.updateItem(item) ? "Предмет изменён" : "Произошла ошибка";
    }

    @DELETE
    @Path("/{id}")
    public String deleteItem(@PathParam("id") long id) {
        return jdbcService.deleteItem(id) ? "Предмет удалён" : "Произошла ошибка";
    }
}
