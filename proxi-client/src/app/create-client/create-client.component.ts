import { Component, OnInit } from '@angular/core';
import { ClientService } from '../services/client.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateClientComponent implements OnInit {

  constructor(private clientService : ClientService, private router : Router) { }

  ngOnInit() {
  }

  onSubmit(clientForm: NgForm) {
    let client = clientForm.value;
    const client1 = {
      nom: client.nom,
      prenom:client.prenom,
      adresse:client.adresse,
      email:client.email,
      ville:client.ville,
      codePostale:client.codePostale
    }
    this.clientService.addClient(client).subscribe((data) => {
      console.log(client);
      this.router.navigate(['list-clients'])
    })
  }
}