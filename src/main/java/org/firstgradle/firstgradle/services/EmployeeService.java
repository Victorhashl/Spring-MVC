package org.firstgradle.firstgradle.services;

import org.firstgradle.firstgradle.dto.EmployeeDTO;
import org.firstgradle.firstgradle.entities.EmployeeEntity;
import org.firstgradle.firstgradle.respositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

//    @Autowired  //Again field injection is not preferred
    final EmployeeRepository employeeRepository;

    @Autowired //This is field injection ,a constructor injection too can be created as below
    ModelMapper modelMapper;

//    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper ){
//        this.employeeRepository = employeeRepository;
//        this.modelMapper = modelMapper;
//    }

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO getEmployeeByID(Long id){
         Optional<EmployeeEntity> employeeEntity= employeeRepository.findById(id);
//         return new EmployeeDTO(employeeEntity.getId(),
//                 employeeEntity.getName(),
//                 employeeEntity.getDateOfBirth(),
//                 employeeEntity.getDateOfJoining(),
//
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO putEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity= modelMapper.map(employeeDTO, EmployeeEntity.class);
//        return new EmployeeDTO(employeeEntity.getId(),employeeEntity.getName(),employeeEntity.getDateOfBirth(),employeeEntity.getDateOfJoining(),employeeEntity.isActive());
        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);


    }

    public List<EmployeeDTO> getAllEmployees() {
        //Iterating through each Entity and mapping it DTO manually using for each loop
//        List<EmployeeEntity> myEntitylist = employeeRepository.findAll();
//        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
//        for (EmployeeEntity employeeEntity : myEntitylist) {
//            employeeDTOList.add(modelMapper.map(employeeEntity, EmployeeDTO.class));
//        }
//        return employeeDTOList;

        //equivalently we can also perform all of it in a single line
        return employeeRepository.findAll()
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());

    }

    public boolean deleteEmployeeByID(Long employeeId) {
        boolean isPresent=employeeRepository.existsById(employeeId);
        if(!isPresent){
            return false;
        }
        employeeRepository.deleteById(employeeId);
        return true;
    }
}
