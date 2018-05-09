import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'sc-input-list-table',
  templateUrl: './input-list-table.component.html',
  styleUrls: ['./input-list-table.component.scss']
})
export class InputListTableComponent implements OnInit {

  public optionsTypeInput: object[] = [
    {value: 'int', text: 'Integer'},
    {value: 'double', text: 'Double'},
    {value: 'boolean', text: 'Boolean'},
  ];

  constructor() {
  }

  ngOnInit() {
  }

  isValidName(name: string) {
    return (name: string) => {const nameRegExp = /^[^`~!@#$%\^&*()_+={}|[\]\\:\s';"<>?,./0-9]*$/;
      return nameRegExp.test(name);}
  }

  tableIsValid() {
    return table => table.every(row => row.listName !== null && row.nrVariables !== null);
  }
}
