import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private router: Router) {
  }

  login(username, password) {
    const user = {username, password};
    return this.http.post('http://localhost:8080/login', user);
  }
  getToken() {
    return localStorage.getItem('token');
  }
  loggedIn() {
    return !!localStorage.getItem('token');
  }
  logout() {
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
