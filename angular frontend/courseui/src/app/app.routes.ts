import { Routes } from '@angular/router';
import {CarComponent} from './components/car/car.component';
import {HomeComponent} from './components/home/home.component';
import {AdminComponent} from './components/admin/admin.component';
import {UserComponent} from './components/user/user.component';
import {LoginComponent} from './components/login/login.component';
import {ForbiddenComponent} from './components/forbidden/forbidden.component';
import {AuthGuard} from './components/auth/auth.guard';

export const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'cars', component:CarComponent},
  {path: 'home', component:HomeComponent},
  {path: 'admin', component:AdminComponent, canActivate:[AuthGuard], data:{roles:['Admin']}},
  {path: 'user', component:UserComponent, canActivate:[AuthGuard], data:{roles:['User']}},
  {path: 'login', component:LoginComponent},
  {path: 'forbidden', component:ForbiddenComponent}
];
