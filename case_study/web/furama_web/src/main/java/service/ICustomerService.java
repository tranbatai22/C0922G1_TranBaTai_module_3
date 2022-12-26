package service;

import model.customer.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> displayListCustomer();

    Map<String,String> insertCustomer(Customer customer);

    Customer findCustomerById(int id);

    Map<String, String> editCustomer(Customer customer);

    boolean deleteCustomer(int id);

    List<Customer> findCustomerByName(String customerName,String customerPhoneNumber, String customerAddress);
}