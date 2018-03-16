import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'sc-input-list-table',
  templateUrl: './input-list-table.component.html',
  styleUrls: ['./input-list-table.component.scss']
})
export class InputListTableComponent implements OnInit {
  @Input() label: string;
  @Input() name: string;

  public optionsTypeInput: object[] = [
    {value: 'int', text: 'Integer'},
    {value: 'double', text: 'Double'},
    {value: 'boolean', text: 'Boolean'},
  ];

  constructor() { }

  ngOnInit() {
  }

}
