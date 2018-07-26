import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";



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

  constructor(private httpClient:HttpClient) {

  }

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

  postRegister() {

    this.httpClient.post("http://localhost:8080/registerServer", {
        firstName: this.firstName,
        lastName: this.lastName,
        user: this.user,
        email: this.email,
        password : this.password,
        phone : this.phone,

      }
    ).subscribe(
      (data:any []) => {
        console.log(data)

      }
    );
  }

}
