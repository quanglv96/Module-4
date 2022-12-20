package guang.xia.service;

import guang.xia.model.Customer;
import guang.xia.model.Province;

public interface ICustomerService extends IGeneralService<Customer>{
    Iterable<Customer> findAllByProvince(Province province);
}
