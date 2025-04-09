package com.test.dao;

import com.test.entity.Master;
import com.test.entity.Specialization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MasterDAOImpl implements MasterDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Master> getAllMasters() {
        Session session = sessionFactory.getCurrentSession();

        List<Master> allMasters = session
                .createQuery("from Master"
                        , Master.class).getResultList();

        return allMasters;
    }

    @Override
    public Master getMaster(int id) {
        Session session = sessionFactory.getCurrentSession();
        Master master = session.get(Master.class, id);
        return master;
    }

    @Override
    public void saveMaster(Master master) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(master);
    }

    @Override
    public void deleteMaster(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Master> query = session.createQuery("delete from Master where id =:masterId");
        query.setParameter("masterId", id);
        query.executeUpdate();
    }

    @Override
    public void addSpecializationToMaster(int masterId, int specializationId) {
        Session session = sessionFactory.getCurrentSession();
        Master master = session.get(Master.class, masterId);
        Specialization specialization = session.get(Specialization.class, specializationId);
        master.getSpecializations().add(specialization);
    }

    @Override
    public void deleteSpecializationTFromMaster(int masterId, int specializationId) {
        Session session = sessionFactory.getCurrentSession();
        Master master = session.get(Master.class, masterId);
        Specialization specialization = session.get(Specialization.class, specializationId);
        master.getSpecializations().remove(specialization);
    }
}
