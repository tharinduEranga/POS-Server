package lk.ijse.absd.servlets.service.spec.impl;

import lk.ijse.absd.servlets.dto.AdminDTO;
import lk.ijse.absd.servlets.entity.Admin;
import lk.ijse.absd.servlets.repository.other.RepoFactory;
import lk.ijse.absd.servlets.repository.spec.AdminRepo;
import lk.ijse.absd.servlets.service.spec.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class AdminServiceimpl implements AdminService {

    private AdminRepo adminRepo;
    private ModelMapper modelMapper;
    PasswordEncoder passwordEncoder;

    public AdminServiceimpl() {
        this.adminRepo=new RepoFactory().getRepo(RepoFactory.RepoTypes.ADMIN);
        this.modelMapper=new ModelMapper();
        this.passwordEncoder=new BCryptPasswordEncoder();
    }

    @Override
    public boolean add(AdminDTO adminDTO) {
        return false;
    }

    @Override
    public boolean update(AdminDTO adminDTO) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public AdminDTO search(String s) {
        return null;
    }

    @Override
    public List<AdminDTO> getAll() {
        return null;
    }

    @Override
    public AdminDTO authenticate(AdminDTO adminDTO) {
        try {
            Admin admin = adminRepo.search(adminDTO.getUserName());
            if(admin==null||!passwordEncoder.matches(adminDTO.getPasssword(),admin.getPasssword())){
                return null;
            }
            return modelMapper.map(admin, AdminDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
