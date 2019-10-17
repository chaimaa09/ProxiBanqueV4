import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../models/client';
@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private httpClient:HttpClient) { 
  }
  getAll(){
    return this.httpClient.get<Client[]>("http://localhost:8080/api/clients");
  }
}
