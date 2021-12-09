package myapp.service;

import myapp.model.Role;
import myapp.model.User;

import java.util.List;

public interface RoleService {

    List<Role> allRoles();

    Role findRoleByName(String name);
}