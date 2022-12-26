package service.impl.facility;

import model.facility.RentType;
import repository.IRentTypeRepository;
import repository.impl.facility.RentTypeRepository;
import service.IRentTypeService;

import java.util.List;

public class RentTypeService implements IRentTypeService {
    IRentTypeRepository rentTypeRepository = new RentTypeRepository();
    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAllRentType();
    }
}