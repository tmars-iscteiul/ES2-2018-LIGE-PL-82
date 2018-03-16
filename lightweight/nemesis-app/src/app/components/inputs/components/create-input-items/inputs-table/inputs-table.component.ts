import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'sc-inputs-table',
  templateUrl: './inputs-table.component.html',
  styleUrls: ['./inputs-table.component.scss']
})
export class InputsTableComponent implements OnInit {
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
