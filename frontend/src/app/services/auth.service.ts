import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  constructor(private httpClient:HttpClient) { }

  postRegister(firstName: string,
               lastName: string,
               user: string,
               email: string,
               password: string,
               phone: string,
  ) {

    this.httpClient.post("http://localhost:8080/registerServer", {
        firstName: firstName,
        lastName: lastName,
        user: user,
        email: email,
        password : password,
        phone : phone
      }
    ).subscribe(
      (data:any []) => {
        console.log(data)
      }
    );

  }

  postLogin(name: string,
            password: string,) {
    this.httpClient.post("http://localhost:8080/loginServer", {
        name: name,
        password: password
      }
    ).subscribe(
      (data:any []) => {
        console.log(data)
      }
    );
  }

}
