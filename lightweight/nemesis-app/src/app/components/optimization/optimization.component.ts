import { Component, OnInit } from '@angular/core';
import {RadioComponent} from '@lightweightform/bootstrap-theme';

@Component({
  selector: 'sc-optimization',
  templateUrl: './optimization.component.html',
  styleUrls: ['./optimization.component.scss']
})
export class OptimizationComponent implements OnInit {

  public options: object[] = [
    {value: 'automatic', text: 'Automatic selection'},
    {value: 'semi-automatic', text: 'Semiautomatic selection'},
    {value: 'manual', text: 'Manual selection'},
  ];

  constructor() {}

  public isDisabled() {
    return ([parentForm]) => parentForm.optimizersSelection === 'automatic';
  }

  public isSelectedTypeA() {
    return ([parentForm]) => parentForm.optimizersSelection === 'automatic' && parentForm.optimizersSelection === 'semi-automatic';
  }

  ngOnInit() {
  }

}
