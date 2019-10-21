import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment'
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VirementService {

  constructor(private httpClient:HttpClient) { }

  virement(operation){
    return this.httpClient.put(environment.serverUrlOp+"virement",operation);
  }
}
