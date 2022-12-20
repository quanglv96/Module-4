package guang.xia.service;


import guang.xia.repository.PostRepository;
import guang.xia.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostService implements IPostService {

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object findById(Long id) {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void remove(Long id) {

    }
}
