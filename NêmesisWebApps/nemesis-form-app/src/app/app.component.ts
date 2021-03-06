import {Component, ViewChild} from '@angular/core';
import {AppController, AppService} from '@lightweightform/core';

@Component({
  selector: 'sc-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  @ViewChild('lfApp') lfApp: AppController;

  actions = [
    {
      name: 'Save optimization',
      style: 'outline-secondary',
      icon: 'save',
      callback: () => {
          this.appService.saveValueToFile('nemesis_'+(Date.now() / 1000 | 0)+'.json', {
            onSuccess: () => console.log('Value saved successfully'),
            onError: err => console.error('Error saving file: ', err),
          });
      }
    },
    {
      name: 'Load optimization',
      style: 'outline-secondary',
      icon: 'folder-open',
      callback: () => {
        this.appService.setValueFromFile({
          onSuccess: () => console.log('Value loaded successfully'),
          onError: err => console.error('Error loading file: ', err),
        });
      },
    },
    {
      name: 'Start the process',
      style: 'outline-success',
      icon: 'send',
      callback: () => {
        this.submit();
      },
    },
  ];

  constructor(private appService: AppService) { }

  submit() {
    if (true) {
      fetch('http://localhost:8080/send_problem', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.appService.value),
        mode: 'cors'
      }).then((response) => {
        console.log(response);
        alert('The process started with sucess. Check your email for details.');
      }).catch((ex) => {
        console.log(ex);
        alert(ex);
      });
    }
    //else {window.alert('Not all variables are defined.');}
  }
}
