package guang.xia.service;
import guang.xia.model.SmartPhone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}