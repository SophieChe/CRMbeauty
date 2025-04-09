package com.test.service;

import com.test.entity.Master;

import java.util.List;

public interface MasterService {
    public List<Master> getAllMasters();

    public Master getMaster(int id);

    public void saveMaster(Master master);

    public void deleteMaster(int id);
    public void addSpecializationToMaster(int masterId, int specializationId);
    public void deleteSpecializationTFromMaster(int masterId, int specializationId);
}
