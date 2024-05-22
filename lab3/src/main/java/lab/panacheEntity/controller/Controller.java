package lab.panacheEntity.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lab.panacheEntity.dto.ChangeCostDTO;
import lab.panacheEntity.dto.ConverterDTO;
import lab.panacheEntity.dto.AddItemDTO;
import lab.panacheEntity.dto.ItemDTO;
import lab.panacheEntity.entity.Item;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class Controller {
    @Transactional
    public ItemDTO addItem(AddItemDTO addItemDTO) {
        Item item = ConverterDTO.toItem(addItemDTO);

        item.persist();

        return ConverterDTO.toItemDTO(item);
    }

    public List<ItemDTO> getAllItems() {
        List<Item> items = Item.listAll();
        return items.stream()
                .map(item -> ConverterDTO.toItemDTO(item))
                .collect(Collectors.toList());
    }

    @Transactional
    public ItemDTO deleteItem(long id) {
        Item item = Item.findById(id);

        if (item == null)
            return null;

        item.delete();
        return ConverterDTO.toItemDTO(item);
    }

    @Transactional
    public ItemDTO updateItem(ItemDTO updateItemDTO) {
        Item item = Item.findById(updateItemDTO.getId());

        if (item == null)
            return null;

        item.setName(updateItemDTO.getName());
        item.setRare(updateItemDTO.getRare());
        item.setCost(updateItemDTO.getCost());
        item.setCount(updateItemDTO.getCount());
        return ConverterDTO.toItemDTO(item);
    }

    public ItemDTO getItemById(long id) {
        Item item = Item.findById(id);
        if (item != null)
            return ConverterDTO.toItemDTO(item);
        return null;
    }

    public List<ItemDTO> getItemsByName(String name) {
        List<Item> items = Item.find("name", name).list();
        return items.stream()
                .map(item -> ConverterDTO.toItemDTO(item))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ItemDTO> changeCost(ChangeCostDTO changeCostDTO) {
        List<Item> items = Item.listAll();
        items.stream()
                .forEach(item -> item.setCost((int) (item.getCost() * changeCostDTO.getMultiply())));

        return getAllItems();
    }

    @Transactional
    public ItemDTO addExpensive(List<AddItemDTO> addItemDTOs) {
        AddItemDTO addItemDTO = addItemDTOs.stream()
                .sorted(Comparator.comparingInt(AddItemDTO::getCost).reversed())
                .findFirst()
                .orElse(null);
        if (addItemDTO != null)
            return addItem(addItemDTO);
        return null;
    }
}
