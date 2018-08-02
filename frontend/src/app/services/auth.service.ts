import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { UserRegistrationData } from "../interfaces/user-registration-data";
import {AppState} from "../store/interfaces/app.state";
import {Store} from "@ngrx/store";
import * as AuthActions from '../store/actions/auth.actions'
import * as AuthSelectors from '../store/selectors/auth.selectors'
import {Observable} from "rxjs/internal/Observable";

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
        username: userRegistrationData.username,
        password: userRegistrationData.password
      }
    ).subscribe(
      (data:any []) => {
        console.log(data);
        this.store.dispatch(new AuthActions.UpdateTokenAction('newToken'));
        this.store.dispatch(new AuthActions.UpdateUserAction({
          username: 'sasha',
          email: 'sasha@sasa.com'
        }));
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
