package pl.sdacademy.jdbc.resolver;

import com.sun.corba.se.spi.monitoring.StatisticMonitoredAttribute;
import pl.sdacademy.jdbc.config.Database;
import pl.sdacademy.jdbc.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class StudentResolver extends AbstractResolver<Student> {

    private Connection connection = Database.getConnection();

    @Override
    public Student get(int id) {
        return null;
    }

    @Override
    public List<Student> get() {
        List<Student> students = new ArrayList<>();
        try {

            Statement statment = connection.createStatement();
            String sql = "select * from student";
            ResultSet resultSet = statment.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");

                students.add(new Student(id, firstname, lastname));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } return students;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "delete from student where id = " + id;
        Statement statement =null;
        try {
            statement = connection.createStatement();


        } catch (SQLException e) {
            e.printStackTrace();
        } return statement.execute(sql);
    }

    @Override
    public boolean insert(Map<String, String> parms) {
        return false;
    }

    @Override
    public boolean update(int id, Map<String, String> parms) {
        return false;
    }
}
