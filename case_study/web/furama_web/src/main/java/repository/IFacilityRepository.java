package repository;

import model.facility.Facility;

import java.util.List;

public interface IFacilityRepository {

    List<Facility> displayListFacility();

    boolean insertFacility(Facility facility);

    Facility findFacilityById(int id);

    boolean editFacility(Facility facility);

    boolean deleteFacility(int id);

    List<Facility> findFacility(String facilityName, int rentTypeID);
}