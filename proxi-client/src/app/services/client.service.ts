import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../models/client';
import {environment} from '../../environments/environment' 
@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private httpClient:HttpClient) { 
  }
  getAll(){
    return this.httpClient.get<Client[]>(environment.serverUrl+"clients");
  }
  deleteClient(code:number){
   return this.httpClient.delete(environment.serverUrl+"clients/"+code);
  }
}