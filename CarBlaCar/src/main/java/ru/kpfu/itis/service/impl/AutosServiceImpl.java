package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.dao.AutosDao;
import ru.kpfu.itis.model.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.service.AutosService;

import java.util.List;
@Component
public class AutosServiceImpl implements AutosService {

    @Qualifier("autosDaoHibernateImpl")
    @Autowired
    private AutosDao autosDao;

    public Automobile addAuto(Automobile automobile) {
        autosDao.save(automobile);
        return automobile;
    }

    public void update(Automobile automobile) {
        autosDao.save(automobile);
    }

    public List<Automobile> findAll() {
        return autosDao.findAll();
    }

    public Automobile findById(Long id) {
        return autosDao.findOne(id);
    }
}
