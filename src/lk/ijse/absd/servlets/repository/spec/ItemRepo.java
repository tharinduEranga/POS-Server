package lk.ijse.absd.servlets.repository.spec;

import lk.ijse.absd.servlets.entity.Item;
import lk.ijse.absd.servlets.repository.other.SuperRepo;

import java.sql.Connection;

public interface ItemRepo extends SuperRepo<Item,Integer> {

    void setConnection(Connection connection);
}
