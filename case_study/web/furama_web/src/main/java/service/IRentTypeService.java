package service;

import model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAllRentType();
}