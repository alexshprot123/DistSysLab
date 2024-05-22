package lab.panacheEntity.dto;

import lab.panacheEntity.entity.Item;

public class ConverterDTO {
    public static ItemDTO toItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId(item.id);
        itemDTO.setName(item.getName());
        itemDTO.setRare(item.getRare());
        itemDTO.setCount(item.getCount());
        itemDTO.setCost(item.getCost());

        return itemDTO;
    }

    public static Item toItem(AddItemDTO addItemDTO) {
        Item item = new Item();

        item.setName(addItemDTO.getName());
        item.setCount(addItemDTO.getCount());
        item.setRare(addItemDTO.getRare());
        item.setCost(addItemDTO.getCost());

        return item;
    }
}
