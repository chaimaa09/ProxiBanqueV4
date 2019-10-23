import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ClientService } from '../services/client.service';
import { Client } from '../models/client';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-details-client',
  templateUrl: './details-client.component.html',
  styleUrls: ['./details-client.component.css']
})
export class DetailsClientComponent implements OnInit {

  code: number;
  client: Client;
  
  constructor(private route: ActivatedRoute,private router: Router,private serviceClient:ClientService, private authService : AuthService) { }

  ngOnInit() {
    this.client = new Client();

    this.code = this.route.snapshot.params['code'];
    
    this.serviceClient.getClientById(this.code)
      .subscribe(data => {
        console.log(data)
        this.client = data;
      })
  }
  list(){
    this.router.navigate(['/list-clients']);
  }
}
