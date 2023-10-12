package vn.techmaster.blogapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.blogapp.entity.Role;
import vn.techmaster.blogapp.entity.User;
import vn.techmaster.blogapp.exception.NotFoundException;
import vn.techmaster.blogapp.model.dto.RoleDto;
import vn.techmaster.blogapp.model.dto.UserDto;
import vn.techmaster.blogapp.model.request.CreateUserRequest;
import vn.techmaster.blogapp.model.request.UpdateUserRequest;
import vn.techmaster.blogapp.repository.RoleRepository;
import vn.techmaster.blogapp.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UserDto createUser(CreateUserRequest request) {
        List<Role> roleList = roleRepository.findAllByIdIn(request.getRoleIds());

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRoles(roleList);
        userRepository.save(user);
        return mapToDo(user);
    }

    public UserDto updateUser(Integer id ,UpdateUserRequest request) {

        List<Role> roleList = roleRepository.findAllByIdIn(request.getRoleIds());
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Khong tim thay user oi id = " + id));
        user.setName(request.getName());
        user.setAvatar(request.getAvatar());
        user.setRoles(roleList);
        userRepository.save(user);
        return mapToDo(user);
    }

    public void deleteUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Khong tim thay user oi id = " + id));
        userRepository.delete(user);
    }

    public UserDto mapToDo(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAvatar(user.getAvatar());

        List<RoleDto> roleDTOs = new ArrayList<>();
        for (Role role : user.getRoles()) {
            RoleDto roleDTO = new RoleDto();
            roleDTO.setId(role.getId());
            roleDTO.setName(role.getName());
            roleDTOs.add(roleDTO);
        }
        userDTO.setRoles(roleDTOs);

        return userDTO;
    }

}
