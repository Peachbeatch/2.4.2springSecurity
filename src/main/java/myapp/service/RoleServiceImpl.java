package myapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import myapp.dao.RoleDAO;
import myapp.model.Role;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> allRoles() {
        return roleDAO.allRoles();
    }

    @Override
    public Role findRoleByName(String name) {
        return roleDAO.findRoleByName(name);
    }
}
