import {Component, NgModule, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {UserRegistrationData} from "../../interfaces/user-registration-data";
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})

@NgModule({
    imports:
      [FormsModule, ReactiveFormsModule]
})

export class RegisterComponent implements OnInit{
  registrationForm: FormGroup;

  constructor( private AuthService: AuthService ) { }

  public register(registerFormData){
    if(this.registrationForm.valid) {
      // TODO: De adaugat metoda CRUD de inregistrare
      this.AuthService.postRegister({
        userName: registerFormData.userName,
        password: registerFormData.password,
        firstName: registerFormData.firstName,
        lastName: registerFormData.lastName,
        email: registerFormData.email,
        phone: registerFormData.phone
      } as UserRegistrationData)
    }
  }

  private initForm() {
    const userName = new FormControl(null, Validators.required)
    const password = new FormControl(null, [Validators.required, ,
      Validators.pattern('(.*[0-9].*[~@#$^()_+={}|,.?: -$)(?!.*[<>";`%].*|.*[~@#$^()_+={}|,.?: -$)(?!.*[<>";`%].*[0-9].*)'),
      Validators.minLength(8)])
    const firstName = new FormControl(null, Validators.required)
    const lastName = new FormControl(null, Validators.required)
    const email = new FormControl(null, [Validators.required, Validators.email])
    const phone = new FormControl(null, Validators.required)

    this.registrationForm = new FormGroup(
      {
        userName: userName,
        password: password,
        firstName: firstName,
        lastName: lastName,
        email: email,
        phone: phone
      })
  }

  ngOnInit() {
    this.initForm();
  }



  /** Creates a POST request to Spring server. */
}
