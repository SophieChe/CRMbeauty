package com.test.service;

import com.test.dao.SpecializationDAO;
import com.test.entity.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpecializationServiceImpl implements SpecializationService{
    @Autowired
    private SpecializationDAO specializationDAO;
    @Override
    @Transactional
    public Specialization getSpecialization(int id) {
        return specializationDAO.getSpecialization(id);
    }

    @Override
    @Transactional
    public void saveSpecialization(Specialization specialization) {
        specializationDAO.saveSpecialization(specialization);
    }

    @Override
    public List<Specialization> getAllSpecializations() {
        return specializationDAO.getAllSpecializations();
    }

//    public Specialization findByName(String name) {
//        return specializationDAO.findByName(name);
//    }
}

