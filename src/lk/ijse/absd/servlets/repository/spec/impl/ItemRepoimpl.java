package lk.ijse.absd.servlets.repository.spec.impl;

import lk.ijse.absd.servlets.entity.Item;
import lk.ijse.absd.servlets.repository.spec.ItemRepo;
import lk.ijse.absd.servlets.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemRepoimpl implements ItemRepo {

    private Connection connection;

    public ItemRepoimpl() {
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Item i) throws SQLException {
        CrudUtil crudUtil=new CrudUtil(connection);
        return crudUtil.executeUpdate("INSERT INTO item values(?,?,?,?)", i.getCode(), i.getName(), i.getPrice(), i.getQty());
    }

    @Override
    public boolean update(Item i) throws SQLException {
        CrudUtil crudUtil=new CrudUtil(connection);
        return crudUtil.executeUpdate("UPDATE item SET name=?,price=?,qty=? WHERE code=?", i.getName(), i.getPrice(), i.getQty(), i.getCode());
    }

    @Override
    public boolean delete(Integer code) throws SQLException {
        CrudUtil crudUtil=new CrudUtil(connection);
        return crudUtil.executeUpdate("DELETE FROM item WHERE code=?", code);
    }

    @Override
    public Item search(Integer code) throws SQLException {
        CrudUtil crudUtil=new CrudUtil(connection);
        ResultSet resultSet = crudUtil.executeQuery("SELECT * FROM item WHERE code=?", code);
        if(resultSet.next()){
            Item item=new Item();
            item.setCode(code);
            item.setName(resultSet.getString("name"));
            item.setPrice(resultSet.getDouble("price"));
            item.setQty(resultSet.getDouble("qty"));
            return item;
        }
        return null;
    }

    @Override
    public List<Item> getAll() throws SQLException {
        CrudUtil crudUtil=new CrudUtil(connection);
        List<Item>items=new ArrayList<>();
        ResultSet resultSet = crudUtil.executeQuery("SELECT * FROM item");
        while (resultSet.next()){
            Item item=new Item();
            item.setCode(resultSet.getInt("code"));
            item.setName(resultSet.getString("name"));
            item.setPrice(resultSet.getDouble("price"));
            item.setQty(resultSet.getDouble("qty"));
            items.add(item);
        }
        return items;
    }
}
