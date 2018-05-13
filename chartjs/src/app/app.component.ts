import { Component } from '@angular/core';
import * as Chart from 'chart.js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Nemesis Results';
  BarChart: any;
  RadarChart: any;
  
  constructor(){}
  ngOnInit(){
    
    //Bar Chart:
    this.BarChart = new Chart('barChart', {
      type: 'bar',
      data:{
        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
        datasets: [{
          label: '# of Votes',
          data: [9,7,3,5,2,10],
          backgroundColor: [
            'rgba(255,99,132,0.2)',
            'rgba(54,162,235,0.2)',
            'rgba(255,206,86,0.2)',
            'rgba(255,99,132,0.2)',
            'rgba(255,99,132,0.2)',
            'rgba(255,99,132,0.2)'
          ],
          borderColor:[
            'rgba(255,99,132,0.2)',
            'rgba(54,162,235,0.2)',
            'rgba(255,206,86,0.2)',
            'rgba(255,99,132,0.2)',
            'rgba(255,99,132,0.2)',
            'rgba(255,99,132,0.2)'
          ],
          borderWidth: 1
        }]
      },
      options: {
        title: "Bar Chart",
        display: true
      },
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: true
          }
        }]
      }
    });
    
    //Radar Chart
    
  }
}