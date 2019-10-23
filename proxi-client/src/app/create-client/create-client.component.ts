import { Component, OnInit } from '@angular/core';
import { ClientService } from '../services/client.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateClientComponent implements OnInit {

  constructor(private clientService : ClientService, private router : Router, private authService : AuthService) { }

  ngOnInit() {
  }

  onSubmit(clientForm: NgForm) {
    const client = clientForm.value;
    
    const client1 = {
      nom: client.nom,
      prenom:client.prenom,
      adresse:client.adresse,
      email:client.email,
      ville:client.ville,
      codePostale:client.codePostale,
      compteCourant : {
        solde : client.soldeCourant
      },
      compteEpargne : {
        solde : client.soldeEpargne ? client.soldeEpargne : null
      }
    }
    this.clientService.addClient(client1).subscribe((data) => {
      console.log(client1);
      this.router.navigate(['/list-clients'])
    })
  }
}
