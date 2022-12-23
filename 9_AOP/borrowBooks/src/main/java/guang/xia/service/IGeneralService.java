package guang.xia.service;

import guang.xia.model.User;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

    Optional<User> findUserByCode(String code);

}
