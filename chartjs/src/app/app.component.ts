import {Component, HostListener} from '@angular/core';
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

  constructor() {}
  @HostListener('nginit') ngOnInit() {
    // Loading data from json
   /* $.getJSON("data.json", function(json) {
      // will generate array with ['Monday', 'Tuesday', 'Wednesday']
      var labels = json.map(function(item) {
        return item.timestamp;
      });

      var data = {
        labels: labels,
        datasets: [
          {
            label: "My First dataset",
            fillColor: "rgba(220,220,220,0.5)",
            strokeColor: "rgba(220,220,220,0.8)",
            highlightFill: "rgba(220,220,220,0.75)",
            highlightStroke: "rgba(220,220,220,1)",
            data: [65, 59, 80, 81, 56, 55, 40]
          },
          {
            label: "My Second dataset",
            fillColor: "rgba(151,187,205,0.5)",
            strokeColor: "rgba(151,187,205,0.8)",
            highlightFill: "rgba(151,187,205,0.75)",
            highlightStroke: "rgba(151,187,205,1)",
            data: [28, 48, 40, 19, 86, 27, 90]
          }
        ]
      };

      var ctx = document.getElementById("myChart").getContext("2d");
      ctx.canvas.width = 1000;
      ctx.canvas.height = 800;

      var myChart = new Chart(ctx).Bar(data);
    });
    */
    
    // Bar Chart:
    this.BarChart = new Chart('barChart', {
      type: 'bar',
      data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
          label: '# of Votes',
          data: [9, 7, 3, 5, 2, 10],
          backgroundColor: [
            'rgba(255,99,132,0.2)',
            'rgba(54,162,235,0.2)',
            'rgba(255,206,86,0.2)',
            'rgba(255,99,132,0.2)',
            'rgba(255,100,132,0.2)',
            'rgba(255,101,132,0.2)'
          ],
          borderColor: [
            'rgba(255,99,132,0.2)',
            'rgba(54,162,235,0.2)',
            'rgba(255,206,86,0.2)',
            'rgba(255,99,132,0.2)',
            'rgba(255,100,132,0.2)',
            'rgba(255,101,132,0.2)'
          ],
          borderWidth: 1
        }]
      },
      options: {
        title: 'Bar Chart',
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
  }

  submit() {
    console.log('test');
    fetch('http://localhost:8080/request_problem', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify('{"name":"test"}'),
      mode: 'cors'
    }).then((response) => {
      console.log(response);
      alert(JSON.stringify(response));
    }).catch((ex) => {
      console.log(ex);
      alert(ex);
    });
  }

  // Radar Chart

}
