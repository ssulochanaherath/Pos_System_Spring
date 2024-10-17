package lk.ijse.pos_system_spring.service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.pos_system_spring.CustomStatusCode.SelectCustomerAndItemAndOrderErrorStatus;
import lk.ijse.pos_system_spring.dao.ItemDao;
import lk.ijse.pos_system_spring.dto.Impl.ItemDTO;
import lk.ijse.pos_system_spring.dto.ItemStatus;
import lk.ijse.pos_system_spring.entity.Impl.ItemEntity;
import lk.ijse.pos_system_spring.exception.DataPersistException;
import lk.ijse.pos_system_spring.exception.ItemNotFoundException;
import lk.ijse.pos_system_spring.service.ItemService;
import lk.ijse.pos_system_spring.util.AppUtil;
import lk.ijse.pos_system_spring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping itemMapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setId(AppUtil.generateItemId());
        ItemEntity savedItem=
                itemDao.save(itemMapping.toItemEntity(itemDTO));
        if(savedItem == null){
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public ItemStatus searchItem(String itemId) {
        if(itemDao.existsById(itemId)){
            var selectedItem = itemDao.getReferenceById(itemId);
            return itemMapping.toItemDTO(selectedItem);
        }else {
            return new SelectCustomerAndItemAndOrderErrorStatus(2,"Search Item not found");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity>allItems=itemDao.findAll();
        return itemMapping.asItemDtoLIst(allItems);
    }

    @Override
    public void updateItem(String itemId, ItemDTO updateItemDto) {
        Optional<ItemEntity> findItem =itemDao.findById(itemId);
        if (!findItem.isPresent()){
            throw new ItemNotFoundException("This id "+itemId+" has Item Not Found");
        }else {
            findItem.get().setItemName(updateItemDto.getName());
            findItem.get().setQty(updateItemDto.getQty());
            findItem.get().setUnitPrice(updateItemDto.getUnitPrice());
        }

    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity> findItem=itemDao.findById(itemId);
        if (!findItem.isPresent()){
            throw new ItemNotFoundException("This id "+itemId+" has Item Not Found");
        }else {
            itemDao.deleteById(itemId);
        }

    }
}
