package guang.xia.repository;

import guang.xia.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPostRepository extends JpaRepository<Post, Long> {
}