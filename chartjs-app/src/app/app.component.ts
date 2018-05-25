import {Component, HostListener} from '@angular/core';
import * as Chart from 'chart.js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Nêmesis Results';

  chartTitle = null;
  chartDescription = null;
  userEmail = null;
  outputFunction = null;
  bestAlgorithm = null;
  fitnessOutputList = [];

  constructor() {}
  ngOnInit() {

    var query = window.location.search.substring(1);
    var vars = query.split("=");
    var problemName = null;

    if (vars[0] == "problemName") {
      problemName = vars[1];
    }

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

      this.chartTitle = response.problemName;
      this.chartDescription = response.problemDescription;
      this.userEmail = response.userEmail;
      this.outputFunction = response.outputFunction;
      this.bestAlgorithm = response.bestAlgorithm;
      this.fitnessOutputList = response.fitnessOutputList;

      var ctx = document.getElementById('barChart');
      var chart = new Chart(ctx, {

        type: 'bar',
        data: {
          labels: [],
          datasets: []
        },
        options: {
          layout: {
            padding: {
                left: 100,
                right: 100,
                top: 0,
                bottom: 0
            }
          }
        }


      })

      chart.data.labels.push([this.outputFunction]);

      this.fitnessOutputList.forEach( function(output) {
        var out: {
          label: arguments.join(output.label),
          data: arguments.join(output.data)
        }
        //chart.data.datasets.push(data);
        console.log(output.label);
        console.log(output.data);
        console.log(out);
      });


      chart.update();
    });

  }


/*
var ctx = document.getElementById("myChart");
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});
*/

}
