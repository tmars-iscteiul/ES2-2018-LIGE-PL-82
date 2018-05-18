import { Component, OnInit } from '@angular/core';
import { AppService } from '../../services/app.service';

@Component({
  selector: 'sc-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent implements OnInit {

  constructor(private appService: AppService) { }

  ngOnInit() {
  }

  emailValidator() {
    return (email: string) => this.appService.isValidEmail(email);
  }
}
