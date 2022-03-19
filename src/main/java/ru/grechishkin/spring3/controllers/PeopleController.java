package ru.grechishkin.spring3.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.grechishkin.spring3.dao.PersonDAO;
import ru.grechishkin.spring3.models.Person;
import ru.grechishkin.spring3.multithreading.MyCallable;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) throws SQLException {
        //получим челиков
        model.addAttribute("people", personDAO.getPeoples());
        return "index";
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id, Model model) {
        //получим челика по айди из ДАО
        model.addAttribute("person", personDAO.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }

    @PostMapping("/start")
    public String startTimer() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        List<MyCallable> tasks = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            MyCallable mc = new MyCallable();
            tasks.add(mc);
        }

//        List<Future<Long>> futures = es.invokeAll(tasks);
//
//        for (Future<Long> future: futures) {
//            System.out.println("future.get()" + future.get());
//        }

        Long firstFuture = es.invokeAny(tasks);

        System.out.println("future.get()" + firstFuture);
        System.out.println("FINISHED");
        es.shutdown();
        return "redirect:/people";
    }
}
