import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee-services/employee-service';

@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.css']
})
export class EmployeesListComponent implements OnInit {

  constructor(private service: EmployeeService) { }

  isSuccessful: any;
  employeeData: [];
  errorMessage: any;

  ngOnInit() {

    this.service.listAllEmployees().then((res) => {
        this.isSuccessful = true;
        this.employeeData = res.data;
    }).catch((err) => {
      this.isSuccessful = false;

      if(err.message == "Http failure response for http://localhost:8085/api/employee/employee: 0 Unknown Error"){
        this.errorMessage = "Could not contact backend server. Please check if backend server is running";
      } else {
        this.errorMessage = err.error.message;
      }
    });
  }
}
