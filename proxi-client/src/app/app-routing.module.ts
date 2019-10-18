import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListClientComponent } from './list-client/list-client.component';
import { CreateClientComponent } from './create-client/create-client.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  { path: 'list-clients', component: ListClientComponent },
  { path: 'create-client', component: CreateClientComponent},
  { path: 'login', component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
