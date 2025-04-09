package com.test.dao;

import com.test.entity.Client;
import com.test.entity.Master;
import com.test.entity.Specialization;

import java.util.List;

public interface SpecializationDAO {
    public Specialization getSpecialization(int id);

    public void saveSpecialization(Specialization specialization);
//    public Specialization findByName(String name);
    public List<Specialization> getAllSpecializations();
}
