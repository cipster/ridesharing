import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginFormGroup: FormGroup;

  constructor(private AuthService: AuthService) { }

  ngOnInit() {
    this.initForm()
  }

  private initForm(){
    const username = new FormControl(null, Validators.required);
    const password = new FormControl(null, Validators.required);

    this.loginFormGroup = new FormGroup({
      username: username,
      password: password
    })
  }



  login(loginFormData){
    if(this.loginFormGroup.valid){
      console.log(loginFormData)
      this.AuthService.postLogin({
        userName: loginFormData.userName,
        password: loginFormData.password
      });
    }
  }

}
