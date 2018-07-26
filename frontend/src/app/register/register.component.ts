import {Component, OnInit} from '@angular/core';
import {AuthService} from "../services/auth.service";


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})


export class RegisterComponent implements OnInit{

  user : string = "";
  firstName: string = "";
  lastName: string = "";
  password: string = "";
  email: string = "";
  phone: string = "";

  constructor(private AuthService: AuthService) { }

  ngOnInit() {
  }

  setUser(event:any){
    this.user = event.target.value;
  }

  setFirstName(event:any){
    this.firstName = event.target.value;
  }

  setLastName(event:any){
    this.lastName = event.target.value;
  }

  setPassword(event:any){
    this.password = event.target.value;
  }

  setEmail(event:any){
    this.email = event.target.value;
  }

  setPhone(event:any){
    this.phone = event.target.value;
  }

  /** Creates a POST request to Spring server. */
  postRegister(){
    this.AuthService.postRegister(
      this.firstName,
      this.lastName,
      this.user,
      this.email,
      this.password,
      this.phone)
  }

}
