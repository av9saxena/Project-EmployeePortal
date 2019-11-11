import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee-services/employee-service';

@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.css']
})
export class EmployeesListComponent implements OnInit {

  constructor(private service: EmployeeService) { }

  isSucessful: any;
  employeeData: any;

  ngOnInit() {

    this.service.listAllEmployees().then((res) => {

      if(res.status == "Failure"){
        this.isSucessful = false;
        this.employeeData = res.message;
      } else {
        this.isSucessful = true;
        this.employeeData = res.data;
      }
    }).catch((err) => {
      this.isSucessful = false;
      this.employeeData = "Could not contact backend server. Please check if backend server is running";
    });
  }
}
