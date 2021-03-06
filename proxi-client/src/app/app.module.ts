import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ListClientComponent } from './list-client/list-client.component';
import { CreateClientComponent } from './create-client/create-client.component';
import { LoginComponent } from './login/login.component';

import { EditClientComponent } from './edit-client/edit-client.component';

import { DetailsClientComponent } from './details-client/details-client.component';
import { VirementComponent } from './virement/virement.component';
import { ListConseillerComponent } from './list-conseiller/list-conseiller.component';
import { DetailsConseillerComponent } from './details-conseiller/details-conseiller.component';
import { CreateConseillerComponent } from './create-conseiller/create-conseiller.component';
import { FooterComponent } from './footer/footer.component';
import { ParametrageComponent } from './parametrage/parametrage.component';
import { DashboardComponent } from './dashboard/dashboard.component';
 import { TokenInterceptorService } from './services/token-interceptor.service';
import { AccueilComponent } from './accueil/accueil.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ListClientComponent,
    CreateClientComponent,
    LoginComponent,
    EditClientComponent,
    DetailsClientComponent,
    VirementComponent,
    ListConseillerComponent,
    DetailsConseillerComponent,
    CreateConseillerComponent,
    FooterComponent,
    ParametrageComponent,
    DashboardComponent,
    AccueilComponent
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [ {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true
  } ],
  bootstrap: [AppComponent]
})
export class AppModule { }
