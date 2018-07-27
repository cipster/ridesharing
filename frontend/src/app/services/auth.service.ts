import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { UserRegistrationData } from "../interfaces/user-registration-data";

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
  postRegister(userRegistrationData: UserRegistrationData) {

    this.httpClient.post("http://localhost:8080/registerServer", {
        firstName: userRegistrationData.firstName,
        lastName: userRegistrationData.lastName,
        user: userRegistrationData.username,
        email: userRegistrationData.email,
        password : userRegistrationData.password,
        phone : userRegistrationData.phone,
      }
    ).subscribe(
      (data:any []) => {
        console.log(data)
      }
      /**
       * TODO: In caz de eroare catch, afisare eroare
       */
    );

  }

  /**
   * Represents a function which creates a POST request to
   * Spring server with following parameters, it triggers when a user login.
   * @param {string} user
   * @param {string} password
   */
  postLogin(userRegistrationData: UserRegistrationData) {
    this.httpClient.post("http://localhost:8080/loginServer", {
        user: userRegistrationData.username,
        password: userRegistrationData.password,
      }
    ).subscribe(
      (data:any []) => {
        console.log(data)
      }
    );

    /**
     * TODO: In caz de eroare catch, afisare eroare
     */
  }

}
