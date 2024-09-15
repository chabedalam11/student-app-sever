package com.jtfc.app.service;

import com.jtfc.app.model.Student;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    private String dbUserName = "postgres";
    private String dbPassword = "abc12345";

    @Override
    public boolean saveStudentInfoInDB(Student student) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "insert  into student (id, student_id, student_name, father_name, gender, mobile, educational_qu, religion, age)" +
                            "values(?,?,?,?,?,?,?,?,?)"
            );
            statement.setInt(1, student.getId());
            statement.setString(2, student.getStudentId());
            statement.setString(3, student.getStudentName());
            statement.setString(4, student.getFatherName());
            statement.setString(5, student.getGender());
            statement.setString(6, student.getMobile());
            statement.setString(7, student.getEducationalQu());
            statement.setString(8, student.getReligion());
            statement.setInt(9, student.getAge());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            if(connection != null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                    return false;
                }

            }
        }
    }

    @Override
    public boolean updateStudentInfoInDB(Student student) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "update  student set student_id = ?, student_name =?, father_name = ?, gender = ? , mobile = ? , educational_qu= ?, religion= ?, age= ?" +
                            "where id = ?"
            );

            statement.setString(1, student.getStudentId());
            statement.setString(2, student.getStudentName());
            statement.setString(3, student.getFatherName());
            statement.setString(4, student.getGender());
            statement.setString(5, student.getMobile());
            statement.setString(6, student.getEducationalQu());
            statement.setString(7, student.getReligion());
            statement.setInt(8, student.getAge());
            statement.setInt(9, student.getId());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            if(connection != null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                    return false;
                }

            }
        }
    }

    @Override
    public boolean deleteStudentInfoInDB(Integer id) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "delete from  student " +
                            "where id = ?"
            );
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            if(connection != null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                    return false;
                }

            }
        }
    }

    @Override
    public List<Student> getStudentInfoInDB() {
        List<Student> list = new ArrayList<>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "select * from student order by id"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setStudentId(resultSet.getString("student_id"));
                student.setStudentName(resultSet.getString("student_name"));
                student.setFatherName(resultSet.getString("father_name"));
                student.setGender(resultSet.getString("gender"));
                student.setMobile(resultSet.getString("mobile"));
                student.setEducationalQu(resultSet.getString("educational_qu"));
                student.setReligion(resultSet.getString("religion"));
                student.setAge(resultSet.getInt("age"));
                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }

            }
        }
        return list;
    }


    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection(dbUrl,
                        dbUserName, dbPassword);
        return connection;
    }
}
