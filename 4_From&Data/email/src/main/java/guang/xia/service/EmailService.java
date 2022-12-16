package guang.xia.service;

import guang.xia.model.Email;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmailService implements IEmailService {
    private static final Map<Integer, Email> emailList;

    static {
        emailList = new HashMap<>();
        emailList.put(1, new Email(1,"English",25,true,"King,Asgard"));
        emailList.put(2, new Email(2,"Vietnamese",25,true,"Vua,Asgard"));
        emailList.put(3, new Email(3,"Japanese",25,true,"キング、アスガルド"));
        emailList.put(4, new Email(4,"Chinese",25,true,"国王，阿斯加德"));

    }

    @Override
    public ArrayList<Email> findAll() {
        return new ArrayList<>(emailList.values());
    }

    @Override
    public void save(Email email) {
        emailList.put(email.getId(), email);
    }

    @Override
    public Email findById(int id) {
        return emailList.get(id);
    }

    @Override
    public void update(int id, Email email) {
        emailList.put(id, email);
    }

    @Override
    public void remove(int id) {
        emailList.remove(id);
    }
}
