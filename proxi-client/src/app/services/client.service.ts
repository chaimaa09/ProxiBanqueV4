import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../models/client';
import {environment} from '../../environments/environment' 
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private httpClient:HttpClient) { 
  }
  getAll(){
    return this.httpClient.get<Client[]>(environment.serverUrl+"clients");
  }
  getClientById(code:number){
    return this.httpClient.get<Client>(environment.serverUrl+"clients/"+code)
  }

  deleteClient(code:number):Observable<Object>{
   return this.httpClient.delete(environment.serverUrl+"clients/"+code, {responseType:'text'});
  }

  addClient(client:Client):Observable<Object>{
    return this.httpClient.post(environment.serverUrl+"clients",client);
  }


}