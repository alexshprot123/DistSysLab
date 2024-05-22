package lab.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lab.panacheEntity.controller.Controller;
import lab.panacheEntity.dto.AddItemDTO;
import lab.panacheEntity.dto.ChangeCostDTO;
import lab.panacheEntity.dto.ItemDTO;

import java.util.List;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestPanache {

    @Inject
    Controller controller;

    @GET
    public List<ItemDTO> getALL() {
        return controller.getAllItems();
    }

    @GET
    @Path("/{id}")
    public ItemDTO getItemById(@PathParam("id") long id) {
        return controller.getItemById(id);
    }

    @GET
    @Path("/byName")
    public List<ItemDTO> getByName(@QueryParam("name") String name) {
        return controller.getItemsByName(name);
    }

    @POST
    public ItemDTO addItem(AddItemDTO addItemDTO) {
        return controller.addItem(addItemDTO);
    }

    @PUT
    public ItemDTO changeItem(ItemDTO updateItemDTO) {
        return controller.updateItem(updateItemDTO);
    }

    @DELETE
    @Path("/{id}")
    public ItemDTO deleteItem(@PathParam("id") long id) {
        return controller.deleteItem(id);
    }

    @POST
    @Path("/cost")
    public List<ItemDTO> changeCost(ChangeCostDTO changeCostDTO) {
        return controller.changeCost(changeCostDTO);
    }

    @POST
    @Path("/expensive")
    public ItemDTO changeCost(List<AddItemDTO> rares) {
        return controller.addExpensive(rares);
    }


}
