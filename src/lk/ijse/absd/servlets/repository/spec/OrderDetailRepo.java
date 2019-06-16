package lk.ijse.absd.servlets.repository.spec;

import lk.ijse.absd.servlets.entity.OrderDetail_PK;
import lk.ijse.absd.servlets.entity.OrderDetails;
import lk.ijse.absd.servlets.repository.other.SuperRepo;

import java.sql.Connection;

public interface OrderDetailRepo extends SuperRepo<OrderDetails,OrderDetail_PK> {

    void setConnection(Connection connection);
}
