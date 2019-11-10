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

  public saveEmployeeData(firstName:any, lastname:any, gender:any, dob: any, department:any): void{
    
    let request = {
      "FirstName": firstName,
      "LastName": lastname,
      "Gender": gender,
      "DateOfBirth": dob,
      "Department": department
    }

    this.service.saveNewEmployee(request).then((res) => {

      let isSuccessful;
      let employeeData;

      if(res.status == "Success"){
        isSuccessful = true;
        employeeData = "Employee created successfully. EmployeeID is : " + res.data.EmployeeID;
      } else {
        isSuccessful = false;
        employeeData = "Could not contact backend server. Please check backend server";
      }
    });
  }
}
