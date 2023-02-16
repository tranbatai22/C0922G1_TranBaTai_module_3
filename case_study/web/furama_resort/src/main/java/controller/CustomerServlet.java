package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import service.customer.ICustomerService;
import service.customer.ICustomerTypeService;
import service.customer.impl.CustomerService;
import service.customer.impl.CustomerTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    ICustomerService customerService = new CustomerService();
    ICustomerTypeService customerTypeService = new CustomerTypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
            default:

        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        List<Customer> customerList = customerService.findCustomerByName(name,phoneNumber,address);
        request.setAttribute("customerList", customerList);
        String mess = "";
        if (customerList.size() == 0) {
            mess = "Không tìm thấy";
        }
        request.setAttribute("mess",mess);
        try {
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

//        String name = request.getParameter("name");
//        String phoneNumber = request.getParameter("phone_number");
//        String address = request.getParameter("address");
//        List<Customer> customerList = customerService.findCustomerByName(name, phoneNumber, address);
//        request.setAttribute("customerList", customerList);
//        String mess = "";
//        if (customerList.size() == 0) {
//            mess = "Không tìm thấy";
//        }
//        request.setAttribute("mess",mess);
//        try {
//            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("date_of_birth");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        CustomerType customerType = new CustomerType(customer_type_id);
        Customer customer = new Customer(id, customerType, name, dateOfBirth, gender, idCard, phoneNumber, email, address);
        boolean check = customerService.editCustomer(customer);
        String mess = "Cập nhật không thành công";
        if (check) {
            mess = "Cập nhật thành công";
        }
        request.setAttribute("mess", mess);
        displayListCustomer(request, response);

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String messDelete = "Xóa Không thành công";
        boolean check = customerService.deleteCustomer(id);
        if (check) {
            messDelete = "Xóa Thành công";
        }
        request.setAttribute("messDelete", messDelete);
        displayListCustomer(request, response);
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("date_of_birth");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        CustomerType customerType = new CustomerType(customerTypeId);
        Customer customer = new Customer(customerType, name, dateOfBirth, gender, idCard, phoneNumber, email, address);
        boolean check = customerService.addCustomer(customer);
        String mess = "Thêm mới không thành công  ";
        if (check) {
            mess = "Thêm mới thành công ";
        }
        request.setAttribute("customerTypeList", customerTypeService.findAllCustomerType());
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                formAddCustomer(request, response);
                break;
            default:
                displayListCustomer(request, response);
        }
    }


    private void formAddCustomer(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerTypeList", customerTypeService.findAllCustomerType());
        try {
            request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void displayListCustomer(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerList", customerService.displayCustomer());
        request.setAttribute("customerTypeList", customerTypeService.findAllCustomerType());
        try {
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}