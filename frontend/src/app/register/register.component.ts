import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  name : string = "";
  constructor(private httpClient:HttpClient) {

  }

  OnName(event:any){
    this.name = event.target.value;
  }

  ngOnInit() {
  }

  getProfile() {
    console.log(this.name);
    this.httpClient.get("https://api.myjson.com/bins/1dxcc6").subscribe(
      (data:any []) => {
        console.log(data)
      }
    );
  }

  postProfile() {

    this.httpClient.post("https://api.myjson.com/bins/",   {
      id : '2',
      title:'Gigel'
    }).subscribe(

      (data:any []) => {
        console.log(data)
      }

    );
  }
}
