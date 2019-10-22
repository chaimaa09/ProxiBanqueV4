import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Client } from '../models/client';
import { Router } from '@angular/router';
import {AuthService} from "../services/auth.service";
import { Auth } from '../models/auth';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    const user = form.value;
    console.log(user);
      this.authService.login(user.username, user.password).subscribe((response: Auth) => {
        console.log(response);
        if (response.token) {
          localStorage.setItem('token', response.token);
          const user = {id: response.id, username: response.username, role: response.role};
          console.log(user.role);
          localStorage.setItem('user', JSON.stringify(user));
          
          if(user.role==="CONSEILLER"){

            this.router.navigate(['/list-clients']);
          } 
           if(user.role==="Moderateur"){
            this.router.navigate(['/parametrage']);
          }
          if(user.role==="GERANT"){

            this.router.navigate(['/list-conseillers']);
          }
        }
     
      })
    }
  }
