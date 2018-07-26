import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

/** Service with Authentication methods. */
export class AuthService {

  constructor(private httpClient:HttpClient) { }

  /**
   * Represents a function which creates a POST request to
   * Spring server with following parameters, it triggers when a user register.
   * @param {string} firstName
   * @param {string} lastName
   * @param {string} user
   * @param {string} email
   * @param {string} password
   * @param {string} phone
   */
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

  /**
   * Represents a function which creates a POST request to
   * Spring server with following parameters, it triggers when a user login.
   * @param {string} user
   * @param {string} password
   */
  postLogin(user: string,
            password: string,) {
    this.httpClient.post("http://localhost:8080/loginServer", {
        user: user,
        password: password
      }
    ).subscribe(
      (data:any []) => {
        console.log(data)
      }
    );
  }

}
