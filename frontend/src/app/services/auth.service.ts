import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { UserRegistrationData } from "../interfaces/user-registration-data";
import {AppState} from "../store/interfaces/app.state";
import {Store} from "@ngrx/store";
import * as AuthActions from '../store/actions/auth.actions'
import * as AuthSelectors from '../store/selectors/auth.selectors'
import {Observable} from "rxjs/internal/Observable";
import {CarRegistrationData} from "../interfaces/car-registration-data";

@Injectable({
  providedIn: 'root'
})

/** Service with Authentication methods. */
export class AuthService {

  constructor(private httpClient: HttpClient,
              private store: Store<AppState>) { }

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

    this.httpClient.post("http://localhost:8080/persons", {
        firstName: userRegistrationData.firstName,
        lastName: userRegistrationData.lastName,
        userName: userRegistrationData.userName,
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
    this.httpClient.post("http://localhost:8080/login", {
        username: userRegistrationData.userName,
        password: userRegistrationData.password
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

  /**
   * Represents a function which creates a POST request to
   * Spring server with following parameters, it triggers when a car register.
   * @param {string} brand
   * @param {string} model
   * @param {string} licensePlate
   * @param {number} year
   * @param {number} available
   *
   */

  postAddCar(carRegistrationData: CarRegistrationData) {

    this.httpClient.post("http://localhost:8080/cars", {
        brand: carRegistrationData.brand,
        model: carRegistrationData.model,
        licensePlate: carRegistrationData.licensePlate,
        year: carRegistrationData.year,
        availableSeats: carRegistrationData.availableSeats,
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

  public getTokenFromStore$(): Observable<string> {
    return this.store.select(AuthSelectors.token);
  }

  public logOut(){
    // TODO: Implement Logout method
  }

}
