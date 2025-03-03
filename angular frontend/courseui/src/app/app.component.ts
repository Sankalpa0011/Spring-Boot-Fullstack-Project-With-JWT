import { Component } from '@angular/core';
import {HeaderComponent} from './components/header/header.component';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import {ContentComponent} from './components/content/content.component';
import {RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [
    HeaderComponent,
    MatSlideToggleModule,
    MatButtonModule,
    MatSidenavModule,
    ContentComponent,
    RouterOutlet
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'courseui';
  name:string = "SANKALPA";
}
