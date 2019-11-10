import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee-services/employee-service';

@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.css']
})
export class EmployeesListComponent implements OnInit {

  constructor(private service: EmployeeService) { }

  ngOnInit() {

    this.service.listAllEmployees().then((res) => {

      let isSucessful;
      let employeeData;

      if(res.status == null){
        isSucessful = false;
        employeeData = "Could not contact server.";
      } else if(res.status == "Failure"){
        isSucessful = false;
        employeeData = res.message;
      } else {
        isSucessful = true;
        employeeData = res.data;
      }
    });
  }
}
