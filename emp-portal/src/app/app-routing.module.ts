import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeEntryComponent } from './employee-entry/employee-entry.component';
import { EmployeesListComponent } from './employees-list/employees-list.component';
import { HomePageComponent } from './home-page/home-page.component';


const routes: Routes = [
  { path: '', redirectTo:'/home', pathMatch: 'full'},
  { path: 'home', component: HomePageComponent},
  { path: 'newEntry', component: EmployeeEntryComponent},
  { path: 'listEmployees', component: EmployeesListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
