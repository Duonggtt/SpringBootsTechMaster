package com.example.libexpress.controller;

import com.example.libexpress.entity.LibraryCard;
import com.example.libexpress.model.dto.UserDto;
import com.example.libexpress.repository.LibraryCardRepository;
import com.example.libexpress.service.ImageService;
import com.example.libexpress.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/lib-express/admin/users")
public class UserController {

    private final UserService userService;
    @Autowired
    private LibraryCardRepository libraryCardRepository;
    private final ImageService imageService;


    public UserController(UserService userService, ImageService imageService) {
        this.userService = userService;
        this.imageService = imageService;
    }

    //quan ly user


//    @GetMapping("")
//    public String getUserPage(@RequestParam(required = false, defaultValue = "id") String sortField,
//                              @RequestParam(required = false, defaultValue = "1") Integer page,
//                              @RequestParam(required = false, defaultValue = "10") Integer pageSize,
//                              @RequestParam(required = false, defaultValue = "asc") String sortDirection,
//                              Model model) {
//
//        Page<User> pageData = userService.getAllUser(page,pageSize, sortField, sortDirection);
//
//
//
//        // Đảo ngược chiều sắp xếp nếu đã có sắp xếp theo trường đó
//        if (sortDirection.equals("asc")) {
//            sortDirection = "desc";
//        } else {
//            sortDirection = "asc";
//        }
//        model.addAttribute("pageData", pageData);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", pageData.getTotalPages());
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("sortDirection", sortDirection);
//        return "admin/userManagement/user";
//    }

    @GetMapping("")
    public String viewHomePage(Model model) {
        String keyword =null;
        return findPaginated(1, "fullName", "asc",keyword,model);
    }

    @GetMapping("/page/{page}")
    public String findPaginated(@PathVariable(value = "page") Integer page,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDirection") String sortDirection,
                                @RequestParam(value = "keyword", required = false) String keyword,
                                Model model) {
        int limit = 10;
        Page<UserDto> getUserPage = userService.findPaginated(page, limit, sortField, sortDirection,keyword);
        List<UserDto> userList = getUserPage.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", getUserPage.getTotalPages());
        model.addAttribute("totalItems", getUserPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("pageData", getUserPage);
        model.addAttribute("sortDirection",sortDirection);
        model.addAttribute("reverseSortDir",sortDirection.equals("asc") ? "desc" : "asc");
        model.addAttribute("UserList", userList);
        model.addAttribute("keyword", keyword);
        return "admin/userManagement/user";
    }

    @GetMapping("/{id}/detail")
    public String getUserDetailPage(@PathVariable Integer id, Model model) {
        UserDto user = userService.getUserById(id);
        LibraryCard card = libraryCardRepository.findByUserId(id);
        model.addAttribute("card", card);
        model.addAttribute("user",user);
        model.addAttribute("imageList", imageService.getFilesOfCurrentUser());
        return "admin/userManagement/user-detail";
    }

    @GetMapping("/create")
    public String getUserCreatePage(Model model) {

        return "admin/userManagement/user-create";
    }

    @GetMapping("/{id}/detail/create-card")
    public String getUserCreateCardPage(@PathVariable Integer id,Model model) {
        UserDto user = userService.getUserById(id);
        LibraryCard card = libraryCardRepository.findByUserId(id);
        model.addAttribute("card", card);
        model.addAttribute("user",user);
        model.addAttribute("imageList", imageService.getFilesOfCurrentUser());
        return "admin/userManagement/user-create-card";
    }

}
