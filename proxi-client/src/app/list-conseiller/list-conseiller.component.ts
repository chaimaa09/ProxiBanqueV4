import { Component, OnInit } from '@angular/core';
import { Conseiller } from '../models/conseiller';
import { ConseillerService } from '../services/conseiller.service';

@Component({
  selector: 'app-list-conseiller',
  templateUrl: './list-conseiller.component.html',
  styleUrls: ['./list-conseiller.component.css']
})
export class ListConseillerComponent implements OnInit {

  conseillers : Conseiller[];

  constructor(private conseillerService : ConseillerService) { }

  ngOnInit() {
    this.getAll();
  }

  getAll(){
    this.conseillerService.getAll().subscribe((data) => {
      this.conseillers = data;
      console.log(data);
    });
  }

  delete(code:number){
    this.conseillerService.deleteConseiller(code)
    .subscribe((response)=>{
      console.log(response),
        this.getAll()
      }, 
      (error) => console.log(error))
  }
}
