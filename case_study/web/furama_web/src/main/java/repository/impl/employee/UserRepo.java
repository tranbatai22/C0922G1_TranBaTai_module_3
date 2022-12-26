package repository.impl.employee;

import model.employee.EducationDegree;
import model.employee.User;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL = "select * from division";

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                list.add(new User(userName,password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}