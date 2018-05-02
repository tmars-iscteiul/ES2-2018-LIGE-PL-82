import { Injectable } from '@angular/core';
import {format, differenceInYears} from 'date-fns/esm';

@Injectable()
export class AppService {

  constructor() { }

  today() {
    return format(Date.now(), 'YYYY-MM-DD');
  }

  isValidEmail(email: string) {
    const emailRegExp =
      /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    return emailRegExp.test(email);
  }

  isValidName(name: string) {
    const nameRegExp = /^[^`~!@#$%\^&*()_+={}|[\]\\:\s';"<>?,./0-9]*$/;

    return nameRegExp.test(name);
  }
}
