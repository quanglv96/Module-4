package guang.xia.service;

import guang.xia.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();

    void save(Email email);

   Email findById(int id);

    void update(int id, Email email);

    void remove(int id);
}
