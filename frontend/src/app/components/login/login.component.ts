import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {UserRegistrationData} from "../../interfaces/user-registration-data";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username : string = "";
  password : string = "";
  userRegistrationData: UserRegistrationData;

  constructor(private AuthService: AuthService) { }

  ngOnInit() {
  }

  setName(event:any){
    this.username = event.target.value;
  }

  setPassword(event:any){
    this.password = event.target.value;
  }

  /** Creates a POST request to Spring server. */
  postLogin() {
    this.userRegistrationData = {
      username: this.username,
      password: this.password,
    }

    this.AuthService.postLogin(this.userRegistrationData);
  }

}
