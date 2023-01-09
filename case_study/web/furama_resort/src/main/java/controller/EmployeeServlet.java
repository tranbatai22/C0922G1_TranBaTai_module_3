package controller;

import repository.employee.IDivisionRepository;
import service.facility.IFacilityService;
import service.facility.IFacilityTypeService;
import service.facility.IRentTypeService;
import service.facility.impl.FacilityService;
import service.facility.impl.FacilityTypeService;
import service.facility.impl.RentTypeService;
import service.employee.IDivisionService;
import service.employee.IEducationDegreeService;
import service.employee.IEmployeeService;
import service.employee.IPositionService;
import service.employee.impl.DivisionService;
import service.employee.impl.EducationDegreeService;
import service.employee.impl.EmployeeService;
import service.employee.impl.PositionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet",value="/employee")
public class EmployeeServlet extends HttpServlet {

    IEmployeeService employeeService = new EmployeeService();
    IDivisionService divisionService = new DivisionService();
    IPositionService positionService = new PositionService();
    IEducationDegreeService educationDegreeService = new EducationDegreeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                displayEmployee(request, response);
        }
    }

    private void displayEmployee(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("divisionList",divisionService.findAllDivision());
        request.setAttribute("positionList",positionService.findAllPosition());
        request.setAttribute("educationDegreeList",educationDegreeService.findAllEducationDegree());
        request.setAttribute("employeeList", employeeService.displayEmployee());

        try {
            request.getRequestDispatcher("/view/employee/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}