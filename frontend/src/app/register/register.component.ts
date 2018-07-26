import {Component, OnInit} from '@angular/core';
import {AuthService} from "../services/auth.service";
import { UserRegistrationData } from "../interfaces/user-registration-data";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})


export class RegisterComponent implements OnInit{

  username : string = "";
  firstName: string = "";
  lastName: string = "";
  password: string = "";
  email: string = "";
  phone: string = "";

  constructor( private AuthService: AuthService ) { }

  ngOnInit() { }

  setUsername(event: any): void{
    this.username = event.target.value;
  }

  setPassword(event: any): void{
    this.password = event.target.value;
  }

  setFirstName(event: any): void{
    this.firstName = event.target.value;
  }

  setLastName(event: any): void{
    this.lastName = event.target.value;
  }

  setEmail(event: any): void{
    this.email = event.target.value;
  }

  setPhone(event: any): void{
    this.phone = event.target.value;
  }

  userRegistrationData: UserRegistrationData;

  /** Creates a POST request to Spring server. */
  postRegister() {

    this.userRegistrationData = {
      username: this.username,
      password: this.password,
      firstName: this.firstName,
      lastName: this.lastName,
      email: this.email,
      phone: this.phone,
    }

    this.AuthService.postRegister(this.userRegistrationData)
  }

}
