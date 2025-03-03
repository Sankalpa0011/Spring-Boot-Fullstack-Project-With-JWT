import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  public setRoles(roles: []) {
    localStorage.setItem('roles', JSON.stringify(roles));
  }
  public getRoles(): [] {
    return JSON.parse(<string>localStorage.getItem('roles'));
  }

  public setToken(jwtToken: string) {
    localStorage.setItem("jwtToken", jwtToken);
  }
  public getToken(): string {
    return <string>localStorage.getItem('jwtToken');
  }

  public clear() {
    localStorage.clear();
  }

  public isloggedIn() {
    return this.getRoles() && this.getToken();
  }
}



//
// import { Injectable } from '@angular/core';
//
// @Injectable({
//   providedIn: 'root'
// })
// export class UserAuthService {
//
//   constructor() { }
//
//   public setRoles(roles: []) {
//     if (typeof window !== 'undefined') {
//       localStorage.setItem('roles', JSON.stringify(roles));
//     }
//   }
//
//   public getRoles(): [] {
//     if (typeof window !== 'undefined') {
//       return JSON.parse(<string>localStorage.getItem('roles'));
//     }
//     return [];
//   }
//
//   public setToken(jwtToken: string) {
//     if (typeof window !== 'undefined') {
//       localStorage.setItem("jwtToken", jwtToken);
//     }
//   }
//
//   public getToken(): string {
//     if (typeof window !== 'undefined') {
//       return <string>localStorage.getItem('jwtToken');
//     }
//     return '';
//   }
//
//   public clear() {
//     if (typeof window !== 'undefined') {
//       localStorage.clear();
//     }
//   }
//
//   public isloggedIn() {
//     return this.getRoles().length > 0 && this.getToken() !== '';
//   }
// }
