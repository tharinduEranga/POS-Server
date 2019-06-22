package lk.ijse.absd.servlets.repository.spec;

import lk.ijse.absd.servlets.entity.OrderDetail_PK;
import lk.ijse.absd.servlets.entity.OrderDetails;
import lk.ijse.absd.servlets.entity.Orders;
import lk.ijse.absd.servlets.repository.other.SuperRepo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailRepo extends SuperRepo<OrderDetails,OrderDetail_PK> {

    void setConnection(Connection connection);
    List<OrderDetails>getByOrder(int oid) throws SQLException;
}
