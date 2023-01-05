package guang.xia.repository;

import guang.xia.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findProductByNameContaining(String text);
}
