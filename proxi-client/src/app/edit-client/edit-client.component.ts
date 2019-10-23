import { Component, OnInit } from '@angular/core';
import { ClientService } from '../services/client.service';
import { FormGroup, FormBuilder,FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from '../models/client';
import { AuthService } from '../services/auth.service';
 
@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit {
  
  clientForm : FormGroup;
  constructor(private fb : FormBuilder, private activeRoute: ActivatedRoute, private clientService: ClientService, private router: Router, private authService : AuthService) { }

  ngOnInit() {
    this.clientForm = this.fb.group({
      code:[''],
      nom: [''],
      prenom: [''],
      adresse:[''],
      email:[''],
      ville:[''],
      codePostale:['']
    });
    this.activeRoute.params.subscribe( p => {
      this.clientService.getClientById(p.code).subscribe( client => {
      this.clientForm.setValue(client)
      })
    })
  }
  onSubmit(){
    this.clientService.updateClient(this.clientForm.value).subscribe(() =>{
      this.router.navigate(['/list-clients']);
    });
  }
}
