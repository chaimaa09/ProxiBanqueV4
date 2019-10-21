import { Component, OnInit } from '@angular/core';
import { ClientService } from '../services/client.service';
import { Client } from '../models/client';

@Component({
  selector: 'app-list-client',
  templateUrl: './list-client.component.html',
  styleUrls: ['./list-client.component.css']
})
export class ListClientComponent implements OnInit {
  
  clients: Client[];

  constructor(private clientService : ClientService) { }

  ngOnInit() {
    this.getAll();
  }

  getAll(){
    this.clientService.getAll().subscribe((data) => {
      this.clients = data;
      console.log(data);
    });
  }
  
  delete(code:number){
    this.clientService.deleteClient(code)
    .subscribe((response)=>{
      console.log(response),
        this.getAll()
      }, 
      (error) => console.log(error))
  }
    
    
    
}
