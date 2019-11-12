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
        let headers = this.getHeaders();
        return this.httpClient.post(this.saveUrl, data,  headers).toPromise();
    }

    listAllEmployees(): Promise<any>{
        let headers = this.getHeaders();
        return this.httpClient.get(this.listUrl, headers).toPromise();
    }

    getHeaders(): any{

        let httpHeaders = new HttpHeaders({'Content-Type': 'application/json', 
                                            'Accept': 'application/json; charset=utf-8',
                                            'Access-Control-Allow-Origin': 'http://localhost:8085'});

        let httpOptions = {
           headers: httpHeaders
        };

        return httpOptions;
    }
}