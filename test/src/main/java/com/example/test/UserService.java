package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<User> getAllUser(int page, int pageSize, String sortField, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortField);
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize, sort);
        return userRepository.findAll(pageRequest);
    }
}
