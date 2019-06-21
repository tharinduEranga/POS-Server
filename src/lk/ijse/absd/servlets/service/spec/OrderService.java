package lk.ijse.absd.servlets.service.spec;

import lk.ijse.absd.servlets.dto.OrderDTO;
import lk.ijse.absd.servlets.service.other.SuperService;

import java.util.List;

public interface OrderService extends SuperService<OrderDTO,Integer> {
    List<OrderDTO> getAllWithCustName();
}
