package lk.ijse.absd.servlets.repository.spec;

import lk.ijse.absd.servlets.entity.Orders;
import lk.ijse.absd.servlets.repository.other.SuperRepo;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderRepo extends SuperRepo<Orders,Integer> {
    int getLastOrderId() throws SQLException;
    void setConnection(Connection connection);
}
