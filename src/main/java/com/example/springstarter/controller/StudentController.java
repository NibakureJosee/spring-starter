package com.example.springstarter.controller;

import com.example.springstarter.entity.Student;
import com.example.springstarter.entity.UserData;
import com.example.springstarter.services.StudentService;
import com.example.springstarter.services.UserDataService;
import com.example.springstarter.services.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/academics")
public class StudentController {

    private final StudentService studentService;
    private final UserDataService userDataService;
    private final JwtService jwtService;

    @Autowired
    public StudentController(StudentService studentService, UserDataService userDataService, JwtService jwtService) {
        this.studentService = studentService;
        this.userDataService = userDataService;
        this.jwtService = jwtService;
    }

    @PostMapping("/registration")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void addStudent(@RequestBody Student student, HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if (authHeader != null && authHeader.startsWith("Bearer")) {
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
        }
        UserData info = userDataService.loadCurrentUser(username);
        student.setCreated(info);
        studentService.addStudent(student);
    }

    @GetMapping("/info")
    public String info() {
        return "Amazing day";
    }
}
