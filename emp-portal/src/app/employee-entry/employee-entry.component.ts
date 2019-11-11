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

  isSuccessful: any;
  employeeData: any;

  public saveEmployeeData(firstName:any, lastname:any, gender:any, dob: any, department:any): void{
    
    let request = {
      "FirstName": firstName,
      "LastName": lastname,
      "Gender": gender,
      "DateOfBirth": dob,
      "Department": department
    }

    this.service.saveNewEmployee(request).then((res) => {

      if(res.status == "Success"){
        this.isSuccessful = true;
        this.employeeData = "Employee created successfully. EmployeeID is : " + res.data.EmployeeID;
      } else {
        this.isSuccessful = false;
        this.employeeData = res.message;
      }
    }).catch((err) => {
      this.isSuccessful = false;
      this.employeeData = "Could not contact backend server. Please check if backend server is running";
    });
  }
}
