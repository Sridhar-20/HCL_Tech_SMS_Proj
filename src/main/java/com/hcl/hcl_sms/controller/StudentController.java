package com.hcl.hcl_sms.controller;

import com.hcl.hcl_sms.dao.StudentDAO;
import com.hcl.hcl_sms.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class StudentController {

    private final StudentDAO studentDAO;

    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    // ADD FULL TIME
    @GetMapping("/add-full-time")
    public String addFullTimeForm() {
        return "add-full-time";
    }

    @PostMapping("/add-full-time")
    public String addFullTime(@RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String joiningDate,
            @RequestParam double fees) {

        studentDAO.addStudent(
                new FullTimeStudent(firstName, lastName, Date.valueOf(joiningDate), fees));
        return "redirect:/students";
    }

    // ADD PART TIME
    @GetMapping("/add-part-time")
    public String addPartTimeForm() {
        return "add-part-time";
    }

    @PostMapping("/add-part-time")
    public String addPartTime(@RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String joiningDate,
            @RequestParam int hours) {

        studentDAO.addStudent(
                new PartTimeStudent(firstName, lastName, Date.valueOf(joiningDate), hours));
        return "redirect:/students";
    }

    // VIEW ALL
    @GetMapping("/students")
    public String viewAll(Model model) {
        model.addAttribute("students", studentDAO.getAllStudents());
        return "students";
    }

    // VIEW BY ID
    @GetMapping("/view-student")
    public String viewStudentForm() {
        return "view-student";
    }

    @PostMapping("/view-student")
    public String viewStudent(@RequestParam int id, Model model) {
        model.addAttribute("student", studentDAO.getStudentById(id));
        return "view-student-result";
    }

    // REMOVE
    @GetMapping("/remove-student")
    public String removeStudentForm() {
        return "remove-student";
    }

    @PostMapping("/remove-student")
    public String removeStudent(@RequestParam int id) {
        studentDAO.removeStudent(id);
        return "redirect:/students";
    }

    // SORT
    @GetMapping("/students/sort/{type}")
    public String sort(@PathVariable String type, Model model) {

        String column = type.equals("name") ? "first_name" : type.equals("date") ? "joining_date" : "id";

        model.addAttribute("students", studentDAO.getAllStudentsSorted(column));
        return "students";
    }

    @GetMapping("/sort-students")
    public String sortStudentsPage() {
        return "sort-students";
    }

}
