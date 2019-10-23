import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Operation } from '../models/operation';
import { Chart } from 'chart.js';

<<<<<<< HEAD
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  title = 'app';
  data: Operation[];
  url = 'http://localhost:8080/api/listeOperations';
  numero = [];
  dateOp= [];
  montant= [];
  chart = [];
  constructor(private httpClient: HttpClient) {}

  ngOnInit() {
    this.httpClient.get(this.url).subscribe((res: Operation[]) => {
      res.forEach(y => {
        this.dateOp.push(y.dateOp);
        this.montant.push(y.montant);
      });
      this.chart = new Chart('canvas', {
        type: 'bar',
        data: {
          labels: this.dateOp,
          datasets: [
            {
              label:"Montant",
              data: this.montant,
              borderColor: '#3cba9f',
              fill: false
            }
          ]
        },
        options: {
          legend: {
            display: true,
            labels: {
              fontColor: 'rgb(255, 99, 132)'
          }
          },
          title: {
            display: true,
            text: 'Rapport des transaction annuelles '
          },
          scales: {
            xAxes: [{
              /* display: true,
              type: 'time',
              time: {
                unit: 'day'
            } */
            }],
            yAxes: [{
              display: true
            }],
=======

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  title = 'app';
  data: Operation[];
  url = 'http://localhost:8080/api/listeOperations';
  numero = [];
  dateOp : Date[] = [];
  montant= [];
  chart = [];
  chart1 = [];

  /* showBar = true;
  showPie = false;
  
  show(){
    this.showBar = !this.showBar;
    this.showPie = !this.showPie;

  } */
  
  constructor(private httpClient: HttpClient) {}

  
  ngOnInit() {
    this.httpClient.get(this.url).subscribe((res: Operation[]) => {
      res.forEach(y => {
        this.dateOp.push(y.dateOp);
        this.montant.push(y.montant);
      });
      this.chart = new Chart('canvas', {
        type: 'bar',
        data: {
          labels: this.dateOp,
          datasets: [
            {
              label:"Montant",
              data: this.montant,
              backgroundColor : ["#FF6384"],
              borderColor: '#3cba9f',
              fill: false
            }
          ]
        },
        options: {
          legend: {
            display: true,
            labels: {
              fontColor: 'rgb(255, 99, 132)'
          }
          },
          title: {
            display: true,
            text: 'Rapport des transaction annuelles '
          },
          scales: {
            xAxes: [{
              display: true
              
            }],
            yAxes: [{
              display: true
            }],
          }
        }
      });


      this.chart1 = new Chart('canvas1', {
        type: 'pie',
        data: {
          labels: this.dateOp,
          datasets: [
            {
              label:"Montant",
              data: this.montant,
              backgroundColor : ["#FF6384","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
              borderColor: '#3cba9f',
              fill: false
            }
          ]
        },
        options: {
          legend: {
            display: true,
            labels: {
              fontColor: 'rgb(255, 99, 132)'
          }
          },
          title: {
            display: true,
            text: 'Rapport des transaction annuelles '
>>>>>>> branch 'master' of https://github.com/chaimaa09/ProxiBanqueV4.git
          }
        }
      });
    });
  }





}
