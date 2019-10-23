import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ConseillerService } from '../services/conseiller.service';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-create-conseiller',
  templateUrl: './create-conseiller.component.html',
  styleUrls: ['./create-conseiller.component.css']
})
export class CreateConseillerComponent implements OnInit {

  constructor(private conseillerService : ConseillerService, private router : Router, private authService : AuthService) { }

  ngOnInit() {
  }

  onSubmit(conseillerForm: NgForm) {
    const conseiller = conseillerForm.value;
    const conseiller1 = {
      nom: conseiller.nom,
      prenom:conseiller.prenom
    }
    this.conseillerService.addConseiller(conseiller1).subscribe((data) => {
      console.log(conseiller1);
      this.router.navigate(['list-conseillers'])
    })
  }
}
