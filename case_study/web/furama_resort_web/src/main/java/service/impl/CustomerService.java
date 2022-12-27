package service.impl;

import model.customer.Customer;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    @Override
    public List<Customer> displayListCustomer() {
        return null;
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer findCustomerById(int id) {
        return null;
    }

    @Override
    public boolean editCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) {
        return false;
    }

    @Override
    public List<Customer> findCustomerByName(String customerName, String customerPhoneNumber, String customerAddress) {
        return null;
    }
}
