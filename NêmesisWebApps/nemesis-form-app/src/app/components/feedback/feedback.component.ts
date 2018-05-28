import { Component, OnInit } from '@angular/core';
//import { AppService } from '../../services/app.service';
import {AppController, AppService} from '@lightweightform/core';

@Component({
  selector: 'sc-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent implements OnInit {

  constructor(private appService: AppService) { }

  ngOnInit() {
  }

  emailValidator(email: string) {
    const emailRegExp =
      /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    return emailRegExp.test(email);
  }

  sendEmail() {
      fetch('http://localhost:8080/send_feedback', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.appService.value),
        mode: 'cors'
      }).then((response) => {
        console.log(response);
        alert('The feedback email was sent with success. We will reply soon.');
      }).catch((ex) => {
        console.log(ex);
        alert(ex);
      });
  }
}
