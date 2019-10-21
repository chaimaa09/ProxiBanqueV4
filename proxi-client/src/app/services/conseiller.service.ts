import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Conseiller } from '../models/conseiller';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConseillerService {

  constructor(private httpClient : HttpClient) { }

  getAll(){
    return this.httpClient.get<Conseiller[]>(environment.serverUrl+"conseillers");
  }


  getConseillerById(code:number){
    return this.httpClient.get<Conseiller>(environment.serverUrl+"conseillers/"+code)
  }

  
  addConseiller(conseiller):Observable<Object>{
    return this.httpClient.post(environment.serverUrl+"conseillers",conseiller);
  }

  updateConseiller(code, conseiller) {
    return this.httpClient.put(environment.serverUrl + 'conseillers/' + code, conseiller);
  }

  deleteConseiller(code) {
    return this.httpClient.delete(environment.serverUrl + 'conseillers/' + code);
  }
}
