package com.cz.mapper;

import com.cz.model.Admin;

import java.util.List;

public interface AdminMapper {
    public int addAdmin(Admin admin);

    public List<Admin> getAdminAll();

}
