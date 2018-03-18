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
        alert('save not implemented');
      },
    },
    {
      name: 'Load optimization',
      style: 'outline-secondary',
      icon: 'folder-open',
      callback: () => {
        alert('load not implemented');
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
    if (this.lfApp.isValid) {
      fetch('../../outputs/outputs-list.php', {
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
  }
}
