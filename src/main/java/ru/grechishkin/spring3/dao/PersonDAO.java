package ru.grechishkin.spring3.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ru.grechishkin.spring3.models.Person;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom1"));
        people.add(new Person(++PEOPLE_COUNT, "Tom2"));
        people.add(new Person(++PEOPLE_COUNT, "Tom3"));
        people.add(new Person(++PEOPLE_COUNT, "Tom4"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
