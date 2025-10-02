
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentList } from './student-list/student-list';
import { StudentForm } from './student-form/student-form';

export const routes: Routes = [
  { path: 'students', component: StudentList },
  { path: 'addStudent', component: StudentForm }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
