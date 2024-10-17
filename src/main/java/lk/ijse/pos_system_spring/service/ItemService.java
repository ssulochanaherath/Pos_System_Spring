package lk.ijse.pos_system_spring.service;

import lk.ijse.pos_system_spring.dto.Impl.ItemDTO;
import lk.ijse.pos_system_spring.dto.ItemStatus;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    ItemStatus searchItem(String itemId);

    List<ItemDTO> getAllItems();

    void updateItem(String itemId, ItemDTO updateItemDto);

    void deleteItem(String itemId);
}
