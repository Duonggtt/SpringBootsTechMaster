package vn.techmaster.blogapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.blogapp.exception.NotFoundException;
import vn.techmaster.blogapp.model.dto.UserDto;
import vn.techmaster.blogapp.model.request.CreateUserRequest;
import vn.techmaster.blogapp.model.request.UpdateUserRequest;
import vn.techmaster.blogapp.repository.UserRepository;
import vn.techmaster.blogapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/admin/users")
public class UserResource {

    private final UserRepository userRepository;

    private final UserService userService;

    public UserResource(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<UserDto> userDtoList = userRepository.getAllUserDto();
        return ResponseEntity.ok(userDtoList);
    }

    @PostMapping
    public ResponseEntity<?> createUser(CreateUserRequest request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserbyId(@PathVariable Integer id) {
        return ResponseEntity.ok(userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thầy user với id = " + id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, UpdateUserRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return null;
    }

    @PostMapping("/{id}/reset-password")
    public ResponseEntity<?> resetPassword(@PathVariable Integer id) {

        return null;
    }

}
