package com.bridgelabz.employeepayrollappdevelopment.controller;

import com.bridgelabz.employeepayrollappdevelopment.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollappdevelopment.dto.ResponseDTO;
import com.bridgelabz.employeepayrollappdevelopment.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollappdevelopment.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService iEmployeePayrollService;

    @RequestMapping(value= {"","/","get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> empDataList =null;
        empDataList =iEmployeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success",empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("employeeId") int employeeId){
        EmployeePayrollData payrollData=null;
        payrollData=iEmployeePayrollService.getEmployeePayrollDataById(employeeId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id:", payrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData payrollData=null;
        payrollData=iEmployeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee payroll data for:", payrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("employeeId") int employeeId,@RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData payrollData=null;
        payrollData=iEmployeePayrollService.updateEmployeePayrollData(employeeId,employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee payroll Data for: ", payrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("employeeId") int employeeId){
        iEmployeePayrollService.deleteEmployeePayrollData(employeeId);
        ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: ", "employeeId "+employeeId);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

}
