package service.impl.customer;

import common.Regex;
import model.customer.Customer;
import repository.ICustomerRepository;
import repository.impl.customer.CustomerRepository;
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
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Map<String, String> editCustomer(Customer customer) {
        Map<String, String> error = new HashMap<>();
        if (!regex.checkName(customer.getName())) {
            error.put("errorName", "Toàn chữ thôi");
        } else {
            customerRepository.editCustomer(customer);
        }
        return error;
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> findCustomerByName(String customerName, String customerPhoneNumber, String customerAddress) {
        return customerRepository.findCustomerByName(customerName, customerPhoneNumber, customerAddress);
    }
}