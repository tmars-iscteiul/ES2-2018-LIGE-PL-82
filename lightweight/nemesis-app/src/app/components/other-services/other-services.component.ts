import { Component, OnInit } from '@angular/core';
import {computed} from 'mobx-angular';
import {AppService} from '@lightweightform/core';

@Component({
  selector: 'sc-other-services',
  templateUrl: './other-services.component.html',
  styleUrls: ['./other-services.component.scss']
})
export class OtherServicesComponent implements OnInit {

  public optionsYN: object[] = [
    {value: 'yes', text: 'Yes'},
    {value: 'no', text: 'No'},
  ];

  constructor(public appService: AppService) { }

  ngOnInit() {
  }

  @computed
  public get guestsInfo() {
    if (this.appService.value === null) {
      return [];
    }
    const appValue: any = this.appService.value;
    const optionsName = appValue.reservationDetail.otherGuests.otherGuestsTable.reduce((guests: object[], guest) => {
      if (guest !== null && guest.fullName !== null) {
        guests.push({value: guest.fullName, text: guest.fullName});
      }
      return guests;
    }, []);
    if (appValue.reservationDetail.fullName !== null) {
      optionsName.push({value: appValue.reservationDetail.fullName, text: appValue.reservationDetail.fullName});
    }
    return optionsName;
  }
}
