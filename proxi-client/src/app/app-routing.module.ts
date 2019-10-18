import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListClientComponent } from './list-client/list-client.component';
import { CreateClientComponent } from './create-client/create-client.component';
import { EditClientComponent } from './edit-client/edit-client.component';

const routes: Routes = [
  { path: 'list-clients', component: ListClientComponent },
  { path: 'edit-client/:code', component: EditClientComponent},
  { path: 'create-client', component: CreateClientComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
