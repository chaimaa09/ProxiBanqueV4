import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListClientComponent } from './list-client/list-client.component';
import { CreateClientComponent } from './create-client/create-client.component';
import { LoginComponent } from './login/login.component';
import { EditClientComponent } from './edit-client/edit-client.component';
import { DetailsClientComponent } from './details-client/details-client.component';
import { VirementComponent } from './virement/virement.component';
import { ListConseillerComponent } from './list-conseiller/list-conseiller.component';
import { DetailsConseillerComponent } from './details-conseiller/details-conseiller.component';
import { CreateConseillerComponent } from './create-conseiller/create-conseiller.component';
import { ParametrageComponent } from './parametrage/parametrage.component';
import { DashboardComponent } from './dashboard/dashboard.component';


const routes: Routes = [
  { path: '',   redirectTo: '/list-clients', pathMatch: 'full' },
  { path: 'list-clients', component: ListClientComponent },
  { path: 'edit-client/:code', component: EditClientComponent },
  { path: 'create-client', component: CreateClientComponent },
  { path: 'login', component: LoginComponent },
  { path: 'details-client/:code', component: DetailsClientComponent },
  { path: 'virement', component: VirementComponent },
  { path: 'list-conseillers', component: ListConseillerComponent },
  { path: 'details-conseiller/:id', component: DetailsConseillerComponent },
  { path: 'create-conseiller', component: CreateConseillerComponent },
  { path: 'parametrage', component: ParametrageComponent },
  { path: 'dashboard', component: DashboardComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
