package service.employee.impl;

import model.employee.EducationDegree;
import repository.employee.IEducationDegreeRepository;
import repository.employee.impl.EducationDegreeRepository;
import service.employee.IEducationDegreeService;

import java.util.List;

public class EducationDegreeService  implements IEducationDegreeService {
    IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();
    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return educationDegreeRepository.findAllEducationDegree();
    }
}