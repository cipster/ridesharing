import { Component, OnInit } from '@angular/core';
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  name : string = "Ovidiu";
  password : string = "george";

  constructor(private AuthService: AuthService) { }

  ngOnInit() {
  }

  setName(event:any){
    this.name = event.target.value;
  }

  setPassword(event:any){
    this.password = event.target.value;
  }

  postLogin(){
    this.AuthService.postLogin(
      this.name,
      this.password,
    );
  }

}
