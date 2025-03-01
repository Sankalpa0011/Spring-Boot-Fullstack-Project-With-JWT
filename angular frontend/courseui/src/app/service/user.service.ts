import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserAuthService} from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  BASE_URL = "http://localhost:8081"

  // this is because of registration do not need authentication
  requestHeader = new HttpHeaders(
    {"No-Auth":"True"}
  );

  constructor(private httpClient:HttpClient,
              private userAuthService: UserAuthService) {

  }

  public login(loginData:any) {
    return this.httpClient.post(this.BASE_URL + "/authentication", loginData, {headers: this.requestHeader});
  }

  // @ts-ignore
  public roleEqual(allowRoles): boolean {
    let isMatch = false;
    const userRoles: any = this.userAuthService.getRoles();

    if (userRoles != null && userRoles) {
      for (let i= 0; i < userRoles.length; i++) {
        for (let j = 0; j < allowRoles.length; j++) {
          if (userRoles[i].roleName === allowRoles[j]) {
            isMatch = true;
            return isMatch;
          } else {
            return isMatch;
          }
        }
      }
    }

  }

}
