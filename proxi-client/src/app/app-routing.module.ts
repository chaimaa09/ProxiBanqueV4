import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListClientComponent } from './list-client/list-client.component';
import { CreateClientComponent } from './create-client/create-client.component';
import { EditClientComponent } from './edit-client/edit-client.component';
import { DetailsClientComponent } from './details-client/details-client.component';
import { VirementComponent } from './virement/virement.component';


const routes: Routes = [
  { path: 'list-clients', component: ListClientComponent },
  { path: 'edit-client/:code', component: EditClientComponent},
  { path: 'create-client', component: CreateClientComponent},
  { path: 'details-client/:code', component: DetailsClientComponent},
  { path: 'virement', component: VirementComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
