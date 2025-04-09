package com.test.dao;

import com.test.entity.Master;
import com.test.entity.Specialization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SpecializationDAOImpl implements SpecializationDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private Specialization specialization;

    @Override
    public Specialization getSpecialization(int id) {
        Session session = sessionFactory.getCurrentSession();
        Specialization specialization = session.get(Specialization.class, id);
        return specialization;
    }

    @Override
    public void saveSpecialization(Specialization specialization) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(specialization);
    }

    @Override
    public List<Specialization> getAllSpecializations() {
        Session session = sessionFactory.getCurrentSession();
        List<Specialization> allSpecializations = session
                .createQuery("from Specialization", Specialization.class)
                .getResultList();
        return allSpecializations;
    }

}
