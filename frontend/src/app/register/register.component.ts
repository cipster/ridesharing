import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {RequestOptions} from "@angular/http";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})


export class RegisterComponent implements OnInit{

  name : string = "";
  //private headers: ({ "Access-Control-Allow-Origin": '*'; "Access-Control-Allow-Methods": 'GET, POST, OPTIONS, PUT, PATCH, DELETE'; "Access-Control-Allow-Headers": 'X-Requested-With,content-type'; "Access-Control-Allow-Credentials": true });
  constructor(private httpClient:HttpClient) {

  }

  OnName(event:any){
    this.name = event.target.value;
  }

  ngOnInit() {
  }

  getProfile() {
    console.log(this.name);

    this.httpClient.get("http://localhost:8080/start").subscribe(
      (data:any []) => {
        console.log(data)
      }
    );

  }

  /*
    http://localhost:8080/persons/search/findByLastName?name=Paiu

  */

 /* @CrossOrigin(origins = "http://localhost", maxAge = 3600)
  */
   
    postProfile() {

    this.httpClient.post("http://localhost:8080/start", {}
      ).subscribe(
      (data:any []) => {
        console.log(data)

      }
    );
  }
}
