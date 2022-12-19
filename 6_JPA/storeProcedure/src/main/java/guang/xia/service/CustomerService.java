package guang.xia.service;


import guang.xia.model.Customer;
import guang.xia.repository.CustomerRepository;
import guang.xia.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository=new CustomerRepository();

    @Override
    public Boolean insertWithStoredProcedure(Customer customer) {
        return customerRepository.insertWithStoredProcedure(customer);
    }

}
