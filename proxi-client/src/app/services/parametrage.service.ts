import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Parametrage } from '../models/parametrage';

@Injectable({
  providedIn: 'root'
})
export class ParametrageService {

  constructor(private httpClient : HttpClient ) { }

  updateParametrage(parametrage : Parametrage):Observable<Object>{
    return this.httpClient.put(environment.serverUrl+"parametrage/" + parametrage.id, parametrage);
  }

  getParametrageById(id : number):Observable<Object>{
    return this.httpClient.get(environment.serverUrl+"parametrage/" + 0);
  }
}
