import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  public token: string = '';

  constructor(public authService: AuthService) { }

  ngOnInit() {
    this.authService.getTokenFromStore$().subscribe((token) => {
      this.token = token;
    });
  }


}
