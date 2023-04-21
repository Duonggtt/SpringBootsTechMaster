package com.example.usermanager.service;

import com.example.usermanager.model.User;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public interface ImageService {
    Image setImage(int id);
    Image getImage(int id);
}
