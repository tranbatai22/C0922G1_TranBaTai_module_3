package service.employee.impl;


import model.employee.Division;
import repository.employee.IDivisionRepository;
import repository.employee.IEmployeeRepository;
import repository.employee.impl.DivisionRepository;
import repository.employee.impl.EmployeeRepository;
import service.employee.IDivisionService;

import java.util.List;

public class DivisionService  implements IDivisionService {
    IDivisionRepository divisionRepository = new DivisionRepository();
    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAllDivision();
    }
}