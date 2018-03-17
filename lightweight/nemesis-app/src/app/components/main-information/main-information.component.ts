import { Component, OnInit } from '@angular/core';
import { AppService } from '../../services/app.service';

@Component({
  selector: 'sc-main-information',
  templateUrl: './main-information.component.html',
  styleUrls: ['./main-information.component.scss']
})
export class MainInformationComponent implements OnInit {

  public optionsScaleInput: object[] = [
    {value: 'min', text: 'Minutes'},
    {value: 'hour', text: 'Hours'},
    {value: 'day', text: 'Days'},
  ];

  constructor(private appService: AppService) { }

  ngOnInit() {
  }

  emailValidator() {
    return (email: string) => this.appService.isValidEmail(email);
  }

  nameValidator() {
    return (name: string) => this.appService.isValidName(name);
  }

}
