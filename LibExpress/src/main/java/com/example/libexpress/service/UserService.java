package com.example.libexpress.service;

import com.example.libexpress.entity.LibraryCard;
import com.example.libexpress.entity.User;
import com.example.libexpress.exception.NotFoundException;
import com.example.libexpress.model.dto.UserDto;
import com.example.libexpress.model.request.CreateUserRequest;
import com.example.libexpress.model.request.UpdateUserRequest;
import com.example.libexpress.repository.LibraryCardRepository;
import com.example.libexpress.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LibraryCardRepository cardRepository;


//    public Page<User> findPaginated(Integer page, Integer limit, String sortField, String sortDirection) {
//        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
//
//        Pageable pageable = PageRequest.of(page - 1, limit,sort);
//        return  this.userRepository.findAll(pageable);
//    }


    public Page<UserDto> findPaginated(Integer page, Integer limit, String sortField, String sortDirection,String keyword) {
        Sort sort = buildSort(sortField, sortDirection);

        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<User> userPage;
        if(keyword != null) {
            userPage = userRepository.findAll(keyword,pageable);
        }else {
            userPage = userRepository.findAll(pageable);
        }

        List<UserDto> userDtoList = userPage.getContent().stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());

        return new PageImpl<>(userDtoList, pageable, userPage.getTotalElements());
    }

    private Sort buildSort(String sortField, String sortDirection) {
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    }

    public UserDto createUser(CreateUserRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setFullName(request.getFirstName() + " " + request.getLastName());
        user.setBirthDate(request.getBirthDate());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setStatus(true);
        user.setCardCreated(false);
        user.setPassword("123");
        userRepository.save(user);
        return convertToUserDto(user);
    }

    public UserDto updateUser(Integer id,UpdateUserRequest request) {
        User user =userRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Khong tim thay user voi id = " + id));

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setFullName(request.getFirstName() + " " + request.getLastName());
        user.setBirthDate(request.getBirthDate());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setStatus(request.isStatus());
        userRepository.save(user);
        return convertToUserDto(user);
    }

    public LibraryCard createCard(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        LibraryCard libraryCard = new LibraryCard();
        // Gán user cho thẻ thư viện
        libraryCard.setUser(user);
        // Gán tên người dùng và ngày sinh từ thông tin user
        libraryCard.setUsername(user.getFirstName() + " " + user.getLastName());
        libraryCard.setUserBirthDate(user.getBirthDate());
        // Gán ngày tạo thẻ và ngày hết hạn
        libraryCard.setCreatedAt(new Date());
        // Giả sử thẻ hết hạn sau 1 năm
        libraryCard.setEnd_at(new Date(System.currentTimeMillis() + (365 * 24 * 60 * 60 * 1000)));
        libraryCard.setAvatar(user.getAvatar());

        // Lưu thẻ thư viện vào cơ sở dữ liệu
        cardRepository.save(libraryCard);
        user.setCardCreated(true);

        userRepository.save(user);
        return libraryCard;
    }

    private UserDto convertToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName(user.getFirstName() + " " + user.getLastName());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setBirthDate(user.getBirthDate());
        // Tách thông tin ngày sinh thành năm, tháng, ngày
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        userDto.setBirthYear(Integer.parseInt(sdf.format(user.getBirthDate())));

        sdf.applyPattern("MM");
        userDto.setBirthMonth(Integer.parseInt(sdf.format(user.getBirthDate())));

        sdf.applyPattern("dd");
        userDto.setBirthDay(Integer.parseInt(sdf.format(user.getBirthDate())));

        userDto.setAddress(user.getAddress());
        userDto.setPhone(user.getPhone());
        userDto.setEmail(user.getEmail());
        userDto.setStatus(user.isStatus());
        userDto.setCardCreated(user.isCardCreated());
        userDto.setAvatar(user.getAvatar());
        return userDto;
    }
    public Page<User> getAllUser(Integer page, Integer limit , String sortField, String sortDirection) {

        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);
        return userRepository.findAll(pageRequest);
    }

    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can't not find user by id= " + id));

        return convertToUserDto(user);
    }



    public Page<User> getAllUserSortedByNameDesc(int page, int pageSize, String sortDirection) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), "fullName"));
        return userRepository.findAllOrderByNameDesc(pageRequest);
    }

    public Page<User> getAllUserByIdDESC(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("id").descending());
        return userRepository.findAllByOrderByIdAsc(pageable);
    }

    public Page<User> getAllUserByIdASC(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("id").descending());
        return userRepository.findAllByOrderByIdDesc(pageable);
    }


//    public UserDto createUser(CreateUserRequest request) {
//
//        User user = new User();
//        user.setFullName(request.getFullName());
//        user.setBirthDate(request.getBirthDate());
//        user.setAddress(request.getAddress());
//        user.setEmail(request.getEmail());
//        user.setPhone(request.getPhone());
//        user.setEmail(request.getEmail());
//        user.setStatus(request.isStatus());
//        user.setCardCreated(request.isCardCreated());
//        userRepository.save(user);
//        return mapToDo(user);
//    }

//    public UserDto updateUser(Integer id , UpdateUserRequest request) {
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Khong tim thay user voi id = " + id));
//
//        user.setFullName(request.getFullName());
//        user.setBirthDate(request.getBirthDate());
//        user.setAddress(request.getAddress());
//        user.setEmail(request.getEmail());
//        user.setPhone(request.getPhone());
//        user.setEmail(request.getEmail());
//        user.setStatus(request.isStatus());
//        user.setCardCreated(request.isCardCreated());
//        user.setAvatar(request.getAvatar());
//        userRepository.save(user);
//        return mapToDo(user);
//    }


//    public UserDto mapToDo(User user) {
//        UserDto userDTO = new UserDto();
//        userDTO.setId(user.getId());
//        userDTO.setFullName(user.getFullName());
//        userDTO.setBirthDate(user.getBirthDate());
//        userDTO.setAddress(user.getAddress());
//        userDTO.setPhone(user.getPhone());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setStatus(user.isStatus());
//        userDTO.setCardCreated(user.isCardCreated());
//        userDTO.setAvatar(user.getAvatar());
//
//        return userDTO;
//    }

}
