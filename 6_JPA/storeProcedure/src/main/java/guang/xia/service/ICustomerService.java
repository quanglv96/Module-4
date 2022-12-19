package guang.xia.service;

import guang.xia.model.Customer;
public interface ICustomerService {

    Boolean insertWithStoredProcedure(Customer customer);
}
