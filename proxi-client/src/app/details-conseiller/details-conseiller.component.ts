import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ConseillerService } from '../services/conseiller.service';
import { Conseiller } from '../models/conseiller';

@Component({
  selector: 'app-details-conseiller',
  templateUrl: './details-conseiller.component.html',
  styleUrls: ['./details-conseiller.component.css']
})
export class DetailsConseillerComponent implements OnInit {

  id: number;
  conseiller: Conseiller;
  
  constructor(private serviceConseiller : ConseillerService, private router : Router, private route : ActivatedRoute) { }

  ngOnInit() {
    this.conseiller = new Conseiller();

    this.id = this.route.snapshot.params['id'];
    
    this.serviceConseiller.getConseillerById(this.id)
      .subscribe(data => {
        console.log(data)
        this.conseiller = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['/list-conseillers']);

  }
}
