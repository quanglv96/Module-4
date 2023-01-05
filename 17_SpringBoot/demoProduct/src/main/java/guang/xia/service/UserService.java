//package guang.xia.service;
//
//
//import guang.xia.model.User;
//import guang.xia.model.UserPrinciple;
//import guang.xia.repository.IUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserService implements UserDetailsService,IGeneralService<User> {
//    @Autowired
//    private IUserRepository iUserRepository;
//
//    public Optional<User> findByUsername(String username) {
//        return iUserRepository.findByUsername(username);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> userOptional = iUserRepository.findByUsername(username);
//        if (!userOptional.isPresent()) {
//            throw new UsernameNotFoundException(username);
//        }
//        return UserPrinciple.build(userOptional.get());
//    }
//
//    @Override
//    public Iterable<User> findAll() {
//        return null;
//    }
//
//    @Override
//    public Optional<User> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public void save(User user) {
//        iUserRepository.save(user);
//    }
//
//    @Override
//    public void remove(Long id) {
//
//    }
//
//    @Override
//    public Iterable<User> search(String text) {
//        return null;
//    }
//}