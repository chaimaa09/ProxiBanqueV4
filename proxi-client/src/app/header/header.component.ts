import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

    user = JSON.parse(localStorage.getItem('user'));
    role: string = null
  
  constructor(private router : Router, private authService: AuthService) { }
  
  
  ngOnInit() {

    this.role = this.user.role;
  }
  logout(){
    this.authService.logout();
  }
}

