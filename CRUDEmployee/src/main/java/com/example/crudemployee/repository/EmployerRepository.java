package com.example.crudemployee.repository;

import com.example.crudemployee.model.Employer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class EmployerRepository {
    public ConcurrentHashMap<Integer, Employer> employers = new ConcurrentHashMap<>();

}
