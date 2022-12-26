package repository.impl.employee;

import model.employee.Division;
import model.employee.EducationDegree;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepo {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL = "select * from division";

    public List<EducationDegree> findAll() {
        List<EducationDegree> list = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                list.add(new EducationDegree(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}