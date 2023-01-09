package service.employee.impl;

import model.employee.Position;
import repository.employee.IEmployeeRepository;
import repository.employee.IPositionRepository;
import repository.employee.impl.EmployeeRepository;
import repository.employee.impl.PositionRepository;
import service.employee.IPositionService;

import java.util.List;

public class PositionService  implements IPositionService {
    IPositionRepository positionRepository = new PositionRepository();
    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAllPosition();
    }
}