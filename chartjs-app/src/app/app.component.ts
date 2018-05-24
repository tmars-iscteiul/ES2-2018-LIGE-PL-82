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
  jsonChart = null;
  responseName = null;

  constructor() {}
  ngOnInit() {

    var query = window.location.search.substring(1);
    var vars = query.split("=");
    var problemName = null;

    if (vars[0] == "problemName") {
      problemName = vars[1];
    }

    var json = null;

    fetch('http://localhost:8080/request_problem', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/plain-text',
    },
    body: problemName,
    mode: 'cors'
    })
    .then((response) => response.json())
    .then((response) => {
      console.log(response)
      console.log(response.problemName)
    })
      
      
      //console.log(r['problemName'])

/*
      var data = {
        labels: 'Teste',
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
*/
      })
})
  }
   

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

  // Radar Chart

}
