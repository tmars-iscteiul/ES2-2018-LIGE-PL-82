import { Injectable } from '@angular/core';
import {format, differenceInYears} from 'date-fns/esm';

@Injectable()
export class AppService {

  constructor() { }

  today() {
    return format(Date.now(), 'YYYY-MM-DD');
  }

  eighteenYearsAgo() {
    const now = new Date();
    return format(now.setFullYear(now.getFullYear() - 18), 'YYYY-MM-DD');
  }

  isValidEmail(email: string) {
    const emailRegExp =
      /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    return emailRegExp.test(email);
  }

   age(dateLeft, dateRight): number {
     return differenceInYears(dateLeft, dateRight);
   }
}
