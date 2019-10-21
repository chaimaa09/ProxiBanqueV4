import { Component, OnInit } from '@angular/core';
import { VirementService } from '../services/virement.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-virement',
  templateUrl: './virement.component.html',
  styleUrls: ['./virement.component.css']
})
export class VirementComponent implements OnInit {
myClients:any;
  constructor(private serviceVirement:VirementService) { }

  ngOnInit() {
  }
  virement(detailVirement: NgForm){
  const data ={
    compteD: detailVirement.value.compteD,
    compteC: detailVirement.value.compteC,
    montant: detailVirement.value.montant
  }
  this.serviceVirement.virement(data).subscribe(result=>{
    console.log(result);
  });
  //console.log(data);
}
}
