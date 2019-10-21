import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'proxi-client';
  showFooter: boolean = true;

  constructor(private router: Router) {}
  
  ngOnInit() {
    // listenging to routing navigation event
    this.router.events.subscribe(event => this.modifyHeader(event));
   }

  modifyHeader(location) {
    if (this.router.url != "/login")
    {
        this.showFooter = false;
    } else {
          this.showFooter = true;
      }
 }
}
