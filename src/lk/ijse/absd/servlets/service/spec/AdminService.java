package lk.ijse.absd.servlets.service.spec;

import lk.ijse.absd.servlets.dto.AdminDTO;
import lk.ijse.absd.servlets.service.other.SuperService;

public interface AdminService extends SuperService<AdminDTO,String> {
    AdminDTO authenticate(AdminDTO adminDTO);
}
