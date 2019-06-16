package lk.ijse.absd.servlets.repository.spec.impl;

import lk.ijse.absd.servlets.entity.Admin;
import lk.ijse.absd.servlets.repository.spec.AdminRepo;
import lk.ijse.absd.servlets.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminRepoimpl implements AdminRepo {
    @Override
    public boolean add(Admin admin) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Admin admin) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public Admin search(String userName) throws SQLException {
        CrudUtil crudUtil = new CrudUtil();
        ResultSet resultSet = crudUtil.executeQuery("SELECT * FROM admin WHERE username=?", userName);
        if(resultSet.next()){
            Admin admin = new Admin();
            admin.setUserName(userName);
            admin.setPasssword(resultSet.getString("password"));
            crudUtil.closeConnection();
            return admin;
        }
        crudUtil.closeConnection();
        return null;
    }

    @Override
    public List<Admin> getAll() throws SQLException {
        return null;
    }

}
