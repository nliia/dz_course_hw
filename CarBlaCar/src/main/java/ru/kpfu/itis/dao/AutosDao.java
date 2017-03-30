package ru.kpfu.itis.dao;

import ru.kpfu.itis.model.Automobile;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AutosDao {

    void save(Automobile automobile);

    List<Automobile> findAll();

    Automobile findOne(Long id);

}
