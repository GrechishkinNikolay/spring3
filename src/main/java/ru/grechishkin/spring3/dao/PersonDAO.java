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
        people.add(new Person(++PEOPLE_COUNT, "Tom1",23,"liop@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Tom2",35,"krok@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Tom3",48,"pust@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Tom4",21,"perd@mail.ru"));
    }

    public List<Person> getPeoples() {
        return people;
    }

    public Person show(int id) {
        return people
            .stream()
            .filter(person -> person.getId() == id)
            .findAny()
            .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person oldPerson = show(id);
        oldPerson.setName(person.getName());
        oldPerson.setAge(person.getAge());
        oldPerson.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
