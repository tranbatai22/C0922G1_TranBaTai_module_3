package controler;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.ICustomerTypeRepository;
import service.ICustomerService;
import service.impl.customer.CustomerService;
import service.impl.customer.CustomerTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    ICustomerTypeRepository customerTypeRepository = new CustomerTypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "insert":
                insertCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phone_number");
        String address = request.getParameter("address");
        List<Customer> customerList = customerService.findCustomerByName(name,phoneNumber,address);
        request.setAttribute("customerList",customerList);
        try {
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String mess = "Xóa Không thành công";
        boolean check = customerService.deleteCustomer(id);
        if (check) {
            mess = "Xóa Thành công";
        }
        request.setAttribute("mess",mess);
        displayListCustomer(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("date_of_birth");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        CustomerType customerType = new CustomerType(customerTypeId);
        Customer customer = new Customer(id, customerType, name, dateOfBirth, gender, idCard, phoneNumber, email, address);
        Map<String,String> error = customerService.editCustomer(customer);
        String mess = "Cập nhật không thành công";
        if (error.isEmpty()) {
            mess = "Cập nhật thành công";
        }else {
            request.setAttribute("error",error);
            request.setAttribute("isModal",true);
        }
        request.setAttribute("mess",mess);
        displayListCustomer(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("date_of_birth");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        CustomerType customerType = new CustomerType(customer_type_id);
        Customer customer = new Customer(customerType, name, dateOfBirth, gender, idCard, phoneNumber, email, address);
        Map<String,String> error = customerService.insertCustomer(customer);
        String mess = "Thêm mới không thành công";
        if (error.isEmpty()) {
            mess = "Thêm mới thành công";
        }else {
            request.setAttribute("error",error);
            request.setAttribute("isModal",true);
        }
        request.setAttribute("mess",mess);
        request.setAttribute("customerTypeList", customerTypeRepository.findAllCustomerType());
        try {
            request.getRequestDispatcher("/view/customer/insert.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "insert":
                showFormInsert(request, response);
                break;
            default:
                displayListCustomer(request, response);
        }
    }

    private void showFormInsert(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerTypeList", customerTypeRepository.findAllCustomerType());
        try {
            request.getRequestDispatcher("/view/customer/insert.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayListCustomer(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerList", customerService.displayListCustomer());
        request.setAttribute("customerTypeList", customerTypeRepository.findAllCustomerType());
        try {
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}