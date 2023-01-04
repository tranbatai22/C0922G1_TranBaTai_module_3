package service.impl;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import model.customer.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();
    private final Regex regex = new Regex();

    @Override
    public List<Customer> displayListCustomer() {
        return customerRepository.displayListCustomer();
    }

    @Override
    public Map<String, String> insertCustomer(Customer customer) {
        Map<String, String> error = new HashMap<>();
        if (!regex.checkName(customer.getName())) {
            error.put("errorName", "Toàn chữ thôi");
        } else {
            customerRepository.insertCustomer(customer);
        }
        return error;
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
