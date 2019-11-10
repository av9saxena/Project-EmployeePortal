import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { resolve } from 'q';

@Injectable()
export class EmployeeService{

    constructor(private httpClient: HttpClient){}

    saveUrl = "http://localhost:8085/api/employee/save";
    listUrl = "http://localhost:8085/api/employee/employee";

    saveNewEmployee(data: any): Promise<any>{
        data = JSON.stringify(data);
        return this.httpClient.post(this.saveUrl, data, {headers: this.getHeaders()}).toPromise();
    }

    listAllEmployees(): Promise<any>{
        return this.httpClient.get(this.listUrl, {headers: this.getHeaders()}).toPromise();
    }

    getHeaders(): HttpHeaders{

        let httpHeaders = new HttpHeaders();

        httpHeaders.append("Content-Type", "application/json; charset=utf-8");
        httpHeaders.append("Accept", "application/json; charset=utf-8");

        return httpHeaders;
    }
}