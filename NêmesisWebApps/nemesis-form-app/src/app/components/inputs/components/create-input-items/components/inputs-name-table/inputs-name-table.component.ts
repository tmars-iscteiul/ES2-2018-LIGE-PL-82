import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'sc-inputs-name-table',
  templateUrl: './inputs-name-table.component.html',
  styleUrls: ['./inputs-name-table.component.scss']
})
export class InputsNameTableComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  isValidName(name: string) {
    return (name: string) => {const nameRegExp = /^[^`~!@#$%\^&*()_+={}|[\]\\:\s';"<>?,./0-9]*$/;
      return nameRegExp.test(name);}
  }
}
