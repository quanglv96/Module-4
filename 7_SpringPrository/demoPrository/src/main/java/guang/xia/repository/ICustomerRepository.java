package guang.xia.repository;

import guang.xia.model.Customer;
import guang.xia.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
        Iterable<Customer> findAllByProvince(Province province);
}
