import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
//http://localhost:8080/loginServer
//https://api.myjson.com/bins


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user : string = "";
  password : string = "";

  constructor(private httpClient:HttpClient) {

  }

  ngOnInit() {
  }

  setName(event:any){
    this.user = event.target.value;
  }

  setPassword(event:any){
    this.password = event.target.value;
  }

  postLogin() {

    this.httpClient.post("http://localhost:8080/loginServer", {
        user: this.user,
        password: this.password
      }
    ).subscribe(
      (data:any []) => {
        console.log(data)

      }
    );
  }

}
