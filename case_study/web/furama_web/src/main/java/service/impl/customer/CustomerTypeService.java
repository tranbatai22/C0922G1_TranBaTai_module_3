package service.impl.customer;

import model.customer.CustomerType;
import repository.ICustomerTypeRepository;
import repository.impl.customer.CustomerTypeRepository;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeRepository {
    ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAllCustomerType();
    }
}