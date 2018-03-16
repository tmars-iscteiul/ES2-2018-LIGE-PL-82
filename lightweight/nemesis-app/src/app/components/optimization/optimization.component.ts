import { Component, OnInit } from '@angular/core';
import {RadioComponent} from '@lightweightform/bootstrap-theme';

@Component({
  selector: 'sc-optimization',
  templateUrl: './optimization.component.html',
  styleUrls: ['./optimization.component.scss']
})
export class OptimizationComponent implements OnInit {

  public options: object[] = [
    {value: 'Automatic', text: 'Automatic selection'},
    {value: 'Semi-automatic', text: 'Semiautomatic selection'},
    {value: 'Manual', text: 'Manual selection'},
  ];

  public optionsCard = {
    style: 'border-secondary',
    headerStyle: 'border-secondary',
    bodyStyle: '',
  };

  constructor() {}

  public onRadio1Change(event) {
    if (event.newValue) {
      
    }
  }

  ngOnInit() {
  }

}
