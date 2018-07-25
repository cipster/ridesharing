import { Component, OnInit } from '@angular/core';

import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  name : string = "Ovidiu";
  password : string = "george";

  constructor(private httpClient:HttpClient) {

  }

  ngOnInit() {
  }

  setName(event:any){
    this.name = event.target.value;
  }

  setPassword(event:any){
    this.password = event.target.value;
  }
//http://localhost:8080/loginServer
//https://api.myjson.com/bins
  postLogin() {

    this.httpClient.post("http://localhost:8080/loginServer", {
        name: this.name,
        password: this.password
      }
    ).subscribe(
      (data:any []) => {
        console.log(data)

      }
    );
  }

}
