import { Component } from '@angular/core';
import {MatIcon} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MenuService} from '../../service/menu.service';
import {Router, RouterLink} from '@angular/router';
import {UserAuthService} from '../../service/user-auth.service';
import {NgIf} from '@angular/common';
import {UserService} from '../../service/user.service';

@Component({
  selector: 'app-header',
  imports: [
    MatIcon,
    MatToolbarModule,
    RouterLink,
    NgIf
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  constructor(private menuService: MenuService,
              private userAuthService: UserAuthService,
              private router: Router,
              protected userService: UserService) {
  }

  toggleMenu() {
    this.menuService.toggle();
  }

  public isloggedIn() {
    return this.userAuthService.isloggedIn();
  }

  public loggedOut() {
    this.userAuthService.clear();
    this.router.navigate(["/home"]);
  }
}
