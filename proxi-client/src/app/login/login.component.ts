import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Client } from '../models/client';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
        this.router.navigate(["/list-clients"]);
  }

  /* onSubmit(form: NgForm) {
    this.auth.login(form.value.email).subscribe((data: Client[]) => {
      if (data.length) {
        localStorage.setItem("token",data[0].id+'');
        this.statusService.changedStatus.next(true);
        this.router.navigate(["/list-user"]);
      } else {
        alert("Login incorrect");
      }
    });
  } */
}
