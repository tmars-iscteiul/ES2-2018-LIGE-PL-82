import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'sc-fitness-table',
  templateUrl: './fitness-table.component.html',
  styleUrls: ['./fitness-table.component.scss']
})
export class FitnessTableComponent implements OnInit {
  constructor() { }

  ngOnInit() {
  }

  isValidName(name: string) {
    return (name: string) => {const nameRegExp = /^[^`~!@#$%\^&*()_+={}|[\]\\:\s';"<>?,./0-9]*$/;
      return nameRegExp.test(name);}
  }
}
