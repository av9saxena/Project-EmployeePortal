import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeEntryComponent } from './employee-entry/employee-entry.component';
import { EmployeesListComponent } from './employees-list/employees-list.component';
import { AppComponent } from './app.component';


const routes: Routes = [
  { path: '', component: AppComponent},
  { path: 'newEntry', component: EmployeeEntryComponent},
  { path: 'listEmployees', component: EmployeesListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
