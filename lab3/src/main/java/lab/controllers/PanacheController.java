package lab.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lab.db.PanacheService;
import lab.dto.AddItemDTO;
import lab.dto.ChangeCostDTO;
import lab.dto.ItemDTO;

import java.util.List;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PanacheController {

    @Inject
    PanacheService panacheService;

    @GET
    public List<ItemDTO> getALL() {
        return panacheService.getAllItems();
    }

    @GET
    @Path("/{id}")
    public ItemDTO getItemById(@PathParam("id") long id) {
        return panacheService.getItemById(id);
    }

    @GET
    @Path("/byName")
    public List<ItemDTO> getByName(@QueryParam("name") String name) {
        return panacheService.getItemsByName(name);
    }

    @POST
    public ItemDTO addItem(AddItemDTO addItemDTO) {
        return panacheService.addItem(addItemDTO);
    }

    @PUT
    public ItemDTO changeItem(ItemDTO updateItemDTO) {
        return panacheService.updateItem(updateItemDTO);
    }

    @DELETE
    @Path("/{id}")
    public ItemDTO deleteItem(@PathParam("id") long id) {
        return panacheService.deleteItem(id);
    }

    @POST
    @Path("/cost")
    public List<ItemDTO> changeCost(ChangeCostDTO changeCostDTO) {
        return panacheService.changeCost(changeCostDTO);
    }

    @POST
    @Path("/expensive")
    public ItemDTO changeCost(List<AddItemDTO> rares) {
        return panacheService.addExpensive(rares);
    }


}
