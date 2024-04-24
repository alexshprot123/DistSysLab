package lab.controller;

import jakarta.enterprise.context.ApplicationScoped;
import lab.dto.ChangeCostDTO;
import lab.dto.ConverterDTO;
import lab.dto.AddItemDTO;
import lab.dto.ItemDTO;
import lab.entity.Item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class Controller {
    private List<Item> items = new ArrayList<>();
    private int lastId = 0;

    public ItemDTO addItem(AddItemDTO addItemDTO) {
        Item item = ConverterDTO.toItem(addItemDTO);

        lastId++;
        item.setId(lastId);
        items.add(item);

        return ConverterDTO.toItemDTO(item);
    }

    public List<ItemDTO> getAllItems() {
        return items.stream()
                .map(item -> ConverterDTO.toItemDTO(item))
                .collect(Collectors.toList());
    }

    public ItemDTO deleteItem(int id) {
        Item item = items.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);

        if (item == null)
            return null;

        items.remove(item);
        return ConverterDTO.toItemDTO(item);
    }

    public ItemDTO updateItem(ItemDTO updateItemDTO) {
        Item item = items.stream()
                .filter(i -> i.getId() == updateItemDTO.getId())
                .findFirst()
                .orElse(null);

        if (item == null)
            return null;

        item.setName(updateItemDTO.getName());
        item.setRare(updateItemDTO.getRare());
        item.setCost(updateItemDTO.getCost());
        item.setCount(updateItemDTO.getCount());
        return ConverterDTO.toItemDTO(item);
    }

    public ItemDTO getItemById(int id) {
        Item item = items.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
        if (item != null)
            return ConverterDTO.toItemDTO(item);
        return null;
    }

    public List<ItemDTO> getItemsByName(String name) {
        return items.stream()
                .filter(item -> item.getName().contains(name))
                .map(item -> ConverterDTO.toItemDTO(item))
                .collect(Collectors.toList());
    }

    public List<ItemDTO> changeCost(ChangeCostDTO changeCostDTO) {
        items.stream()
                .forEach(item -> item.setCost((int) (item.getCost() * changeCostDTO.getMultiply())));

        return getAllItems();
    }

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
