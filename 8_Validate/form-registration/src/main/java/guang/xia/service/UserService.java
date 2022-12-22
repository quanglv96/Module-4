package guang.xia.service;

import guang.xia.model.User;
import guang.xia.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Optional;

public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) throws Exception {
        Optional<User> user=userRepository.findById(id);
        if (!user.isPresent()) {
           throw new Exception("customer not found!");
        }else {
            return user;
        }
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}
