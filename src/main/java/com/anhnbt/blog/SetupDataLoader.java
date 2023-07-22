package com.anhnbt.blog;

import com.anhnbt.blog.common.Constants;
import com.anhnbt.blog.entities.Privilege;
import com.anhnbt.blog.entities.Role;
import com.anhnbt.blog.exception.EmailExistsException;
import com.anhnbt.blog.exception.UsernameExistsException;
import com.anhnbt.blog.model.UserDto;
import com.anhnbt.blog.repository.PrivilegeRepository;
import com.anhnbt.blog.repository.RoleRepository;
import com.anhnbt.blog.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LogManager.getLogger(SetupDataLoader.class);

    boolean alreadySetup = true;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Value(value = "${app.email}")
    private String email;

    @Value(value = "${app.password}")
    private String password;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup) return;
        Privilege readPrivilege = createPrivilegeIfNotFound(Constants.Privileges.READ_PRIVILEGE);
        Privilege writePrivilege = createPrivilegeIfNotFound(Constants.Privileges.WRITE_PRIVILEGE);
        Privilege deletePrivilege = createPrivilegeIfNotFound(Constants.Privileges.DELETE_PRIVILEGE);

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege, deletePrivilege);
        createRoleIfNotFound(Constants.Roles.ROLE_ADMIN, adminPrivileges);
        createRoleIfNotFound(Constants.Roles.ROLE_USER, List.of(readPrivilege));

        Role adminRole = roleRepository.findByName(Constants.Roles.ROLE_ADMIN);
        UserDto user = new UserDto();
        user.setUsername("anhnbt");
        user.setPassword(password);
        user.setEmail(email);
        user.setRoles(List.of(adminRole));
        user.setEnabled(true);
        try {
            userService.save(user);
        } catch (EmailExistsException | UsernameExistsException e) {
            logger.error(e);
        }

        alreadySetup = true;
    }

    @Transactional
    public Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    public void createRoleIfNotFound(String name, Collection<Privilege> privileges) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
    }
}