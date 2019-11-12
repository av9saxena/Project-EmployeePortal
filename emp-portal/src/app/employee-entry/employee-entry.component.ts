import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee-services/employee-service';

@Component({
  selector: 'app-employee-entry',
  templateUrl: './employee-entry.component.html',
  styleUrls: ['./employee-entry.component.css']
})
export class EmployeeEntryComponent implements OnInit {

  constructor(private service: EmployeeService) {}

  ngOnInit() {
  }

  employeeData: any;

  public saveEmployeeData(firstName:any, lastName:any, gender:any, dob: any, department:any): void{
    
    let request = {
      "FirstName": firstName,
      "LastName": lastName,
      "Gender": gender,
      "DateOfBirth": dob,
      "Department": department
    }

    this.service.saveNewEmployee(request).then((res) => {

      if(res.status == "Success"){
        this.employeeData = "Employee created successfully. EmployeeId is : " + res.data.EmployeeId;
      } 
    }).catch((err) => {
      if(err.message == "Http failure response for http://localhost:8085/api/employee/save: 0 Unknown Error"){
        this.employeeData = "Could not contact backend server. Please check if backend server is running";
      } else {
        this.employeeData = err.error.message;
      }
    });
  }
}
