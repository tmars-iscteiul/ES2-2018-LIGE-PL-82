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
  outputsFunction = null;
  optimizationDate = null;
  processTime = null;
  solutionVariablesNumber = null;
  timeScale = null;

  constructor() {}
  ngOnInit() {

    var query = window.location.search.substring(1);
    var vars = query.split("=");
    var problemName = null;

    var chartColors = {
      blue: 'rgb(54, 162, 235)',
      green: 'rgb(75, 192, 192)',
      red: 'rgb(255, 99, 132)',
      orange: 'rgb(255, 159, 64)',
      yellow: 'rgb(255, 205, 86)',
      purple: 'rgb(153, 102, 255)'
    };

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
      this.chartDescription = decodeURIComponent(escape(response.problemDescription));
      this.userEmail = response.userEmail;
      this.optimizationDate = response.optimizationDate;
      this.outputsFunction = response.outputsFunction;
      this.solutionVariablesNumber = response.solutionVariablesNumber;
      this.processTime = response.processTime;

      this.timeScale = 'seconds'

      if (this.processTime > 60) {
        this.processTime = this.processTime / 60;
        this.timeScale = 'minutes';
      }
      if (this.processTime > 120) {
        this.processTime = this.processTime / 60;
        this.timeScale = 'hours';
      }

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
          },
          responsive: 'true',
          legend: {
            position: 'bottom',
          },
          scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
          }
        }


      })

      var colorNames = Object.keys(chartColors);
      
      
      chart.data.labels = response.labels;

      var i = 0;

      response.fitnessOutputList.forEach( function(output) {
        chart.data.datasets.push(output);  

        var colorName = colorNames[i % 6];
        var dsColor = chartColors[colorName];

        console.log(dsColor);
        chart.data.datasets[i].backgroundColor = dsColor;
        i++;     
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
