package controler;

import repository.impl.employee.DivisionRepo;
import repository.impl.employee.EducationDegreeRepo;
import repository.impl.employee.PositionRepo;
import service.IEmployeeService;
import service.impl.employee.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    DivisionRepo divisionRepo = new DivisionRepo();
    EducationDegreeRepo educationDegreeRepo = new EducationDegreeRepo();
    PositionRepo positionRepo =new PositionRepo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
            case "delete":
                removeEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
                break;
        }

    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeEmployee(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showListEmployee(request, response);
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("employeeList", employeeService.displayListEmployee());
        request.setAttribute("divisionList", divisionRepo.findAll());
        request.setAttribute("educationDegreeList", educationDegreeRepo.findAll());
        request.setAttribute("positionList", positionRepo.findAll());
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}