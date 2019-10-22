import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router : Router, private authService: AuthService) { }
  isAuth: boolean = false
  user = null;
  role: string = null;
  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('user'));
    console.log(this.user);
    this.role = this.user.role; 
    console.log(this.role);
    this.isAuth = this.role?true:false;

    
  }
  logout(){
    this.authService.logout();
  }
}

