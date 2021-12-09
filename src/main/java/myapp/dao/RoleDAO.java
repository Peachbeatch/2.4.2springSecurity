package myapp.dao;

import myapp.model.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> allRoles();

    Role findRoleByName(String name);
}