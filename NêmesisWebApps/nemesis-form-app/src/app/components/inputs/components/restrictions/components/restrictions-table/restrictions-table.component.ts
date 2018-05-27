import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'sc-restrictions-table',
  templateUrl: './restrictions-table.component.html',
  styleUrls: ['./restrictions-table.component.scss']
})
export class RestrictionsTableComponent implements OnInit {

  public optionsSymbolInput: object[] = [
    {value: 'bigger', text: '>'},
    {value: 'smaller', text: '<'},
    {value: 'biggerEqual', text: '>='},
    {value: 'smallerEqual', text: '<='},
    {value: 'equals', text: '=='},
    {value: 'different', text: '!='},
  ];

  constructor() { }

  ngOnInit() {
  }

  isValidName(name: string) {
    return (name: string) => {const nameRegExp = /^[^`~!@#$%\^&*()_+={}|[\]\\:\s';"<>?,./0-9]*$/;
      return nameRegExp.test(name);}
  }
}
