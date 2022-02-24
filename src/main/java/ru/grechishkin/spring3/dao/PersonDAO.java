package ru.grechishkin.spring3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ru.grechishkin.spring3.models.Person;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT = 0;

    private static final String URL = "jdbc:postgresql://localhost:5432/ForSpring3";
    private static final String USER_NAME = "postgres";
    private static final String USER_PASSWORD = "123qwe";

    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USER_NAME,USER_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> getPeoples() throws SQLException {
        List<Person> people = new ArrayList<>();
        Statement statement = connection.createStatement();
        String query = "SELECT * from person";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));
            people.add(person);
        }

        return people;
    }

    public Person show(int id) {
//        return people
//            .stream()
//            .filter(person -> person.getId() == id)
//            .findAny()
//            .orElse(null);
        return null;
    }

    public void save(Person person) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
    }

    public void update(int id, Person person) {
//        Person oldPerson = show(id);
//        oldPerson.setName(person.getName());
//        oldPerson.setAge(person.getAge());
//        oldPerson.setEmail(person.getEmail());
    }

    public void delete(int id) {
//        people.removeIf(person -> person.getId() == id);
    }
}
