import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'sc-fitness-app',
  templateUrl: './fitness-app.component.html',
  styleUrls: ['./fitness-app.component.scss']
})
export class FitnessAppComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  isValidName(name: string) {
    return (name: string) => {const nameRegExp = /^[^`~!@#$%\^&*()_+={}|[\]\\:\s';"<>?,./0-9]*$/;
      return nameRegExp.test(name);}
  }
}
