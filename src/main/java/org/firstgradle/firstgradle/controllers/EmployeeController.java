package org.firstgradle.firstgradle.controllers;

import jakarta.websocket.server.PathParam;
import org.firstgradle.firstgradle.dto.EmployeeDTO;
import org.firstgradle.firstgradle.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

@RestController
public class EmployeeController {


    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
        //GET Request to print all the employees
        @GetMapping(path = "/employees")
        public List<EmployeeDTO> getAllEmployees(){
//            return (new EmployeeDTO(1224L,"Victor",LocalDate.of(2000,9,26),LocalDate.now(),true));
            return employeeService.getAllEmployees();
        }

        //GET Request to print employee details with a particular ID
        @GetMapping(path="/employees/{id}")
        public EmployeeDTO getEmployeeByID(@PathVariable Long id){  //Other way to pass id is (@PathVariable("id") Long EmployeeID)
//            return new EmployeeDTO(id,"Random",LocalDate.of(2008,7,16),LocalDate.now(),true);
            return employeeService.getEmployeeByID(id);
        }

        //POST Request to create and add a new Employee to
        @PostMapping(path = "/employees")
        public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO){
            return employeeService.putEmployee(employeeDTO);
        }

        //PUT Request to modify/update the details of particular employee(yet to complete)



        //DELETE Request to remove a retired/resigned employee by ID from the database
        @DeleteMapping(path = "employees/{id}")
        public boolean deleteEmployeeByID(@PathVariable("id") Long EmployeeId){
            return employeeService.deleteEmployeeByID(EmployeeId);

        }


        //Just to print a Hello and Welcome message(for a client facing portal)
        @GetMapping(path = "employee/hello")
    public String hello(@PathParam("text") String name,
                        @PathParam("age") Integer age){   //get output on employee/hello?name={name}&age={age}
            return "Hello "+name+"!Your age is:"+age;
        }
}
