package guang.xia.repository;

import guang.xia.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends IGeneralRepository<Customer> {
    boolean insertWithStoredProcedure(Customer customer);
}
