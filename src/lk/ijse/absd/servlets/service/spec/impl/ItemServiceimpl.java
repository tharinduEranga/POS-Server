package lk.ijse.absd.servlets.service.spec.impl;

import lk.ijse.absd.servlets.db.DBConnection;
import lk.ijse.absd.servlets.dto.ItemDTO;
import lk.ijse.absd.servlets.entity.Item;
import lk.ijse.absd.servlets.repository.other.RepoFactory;
import lk.ijse.absd.servlets.repository.spec.ItemRepo;
import lk.ijse.absd.servlets.service.spec.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;
import java.util.Objects;

public class ItemServiceimpl implements ItemService  {

    private ItemRepo itemRepo;
    private ModelMapper modelMapper;

    public ItemServiceimpl() {
        this.itemRepo=new RepoFactory().getRepo(RepoFactory.RepoTypes.ITEM);
        this.modelMapper=new ModelMapper();
    }

    @Override
    public boolean add(ItemDTO itemDTO) {
        try {
            Connection connection = DBConnection.getConnection();
            itemRepo.setConnection(connection);
            Item item = modelMapper.map(itemDTO, Item.class);
            boolean add = itemRepo.add(item);
            Objects.requireNonNull(connection).close();
            return add;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean update(ItemDTO itemDTO) {
        try {
            Connection connection = DBConnection.getConnection();
            Item item = modelMapper.map(itemDTO, Item.class);
            itemRepo.setConnection(connection);
            boolean update = itemRepo.update(item);
            Objects.requireNonNull(connection).close();
            return update;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer s) {
        try {
            Connection connection = DBConnection.getConnection();
            itemRepo.setConnection(connection);
            boolean delete = itemRepo.delete(s);
            Objects.requireNonNull(connection).close();
            return delete;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ItemDTO search(Integer s) {
        try {
            Connection connection = DBConnection.getConnection();
            itemRepo.setConnection(connection);
            Item item = itemRepo.search(s);
            Objects.requireNonNull(connection).close();
            if(item!=null){
                return modelMapper.map(item,ItemDTO.class);
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ItemDTO> getAll() {
        try {
            Connection connection = DBConnection.getConnection();
            itemRepo.setConnection(connection);
            List<Item> all = itemRepo.getAll();
            connection.close();
            Type listType= new TypeToken<List<ItemDTO>>(){}.getType();
            return modelMapper.map(all,listType);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
