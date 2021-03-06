import { Component, OnInit } from '@angular/core';
import { ParametrageService } from '../services/parametrage.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-parametrage',
  templateUrl: './parametrage.component.html',
  styleUrls: ['./parametrage.component.css']
})
export class ParametrageComponent implements OnInit {

  paramForm : FormGroup;

  
  constructor(private fb : FormBuilder,private activeRoute: ActivatedRoute, private parametrageService : ParametrageService, private router : Router, private authService : AuthService) { }

  ngOnInit() {
    this.paramForm = this.fb.group({
      id:[''],
      commission:[''],
      nombreMaxClient: [''],
      nombreMaxConseiller:[''],
      graphe:['']
    });
    this.activeRoute.params.subscribe( p => {
      console.log(this.parametrageService.getParametrageById(0))
      this.parametrageService.getParametrageById(0).subscribe( parametrage => {
      this.paramForm.setValue(parametrage),
      console.log(parametrage)
      })
    })
  }

  onSubmit(){
    this.parametrageService.updateParametrage(this.paramForm.value).subscribe(() =>{
      this.router.navigate(['/parametrage']);
    });
  }




}
