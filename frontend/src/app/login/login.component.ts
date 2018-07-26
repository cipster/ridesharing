import { Component, OnInit } from '@angular/core';
import {AuthService} from "../services/auth.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user : string = "";
  password : string = "";

  constructor(private AuthService: AuthService) {

  }

  ngOnInit() {
  }

  setName(event:any){
    this.user = event.target.value;
  }

  setPassword(event:any){
    this.password = event.target.value;
  }

  /** Creates a POST request to Spring server. */
  postLogin() {
    this.AuthService.postLogin(
      this.user,
      this.password
    );
  }

}
