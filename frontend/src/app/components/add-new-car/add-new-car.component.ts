import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'add-new-car',
  templateUrl: './add-new-car.component.html',
  styleUrls: ['./add-new-car.component.scss']
})
export class AddNewCarComponent implements OnInit {

  today: number = Date.now();
  addNewCarFormData: FormGroup;

  constructor( private AuthService: AuthService ) { }

  private initForm() {
    const brand = new FormControl(null, Validators.required);
    const model = new FormControl(null, Validators.required);
    const licensePlate = new FormControl(null, Validators.required);
    const year = new FormControl(null, [Validators.required,
    Validators.min(1990), Validators.max(new Date().getFullYear())]);
    const availableSeats = new FormControl(null, [Validators.required,
      Validators.min(1)]);

    this.addNewCarFormData = new  FormGroup(
      {
        brand: brand,
        model: model,
        licensePlate: licensePlate,
        year: year,
        availableSeats: availableSeats
      })
  }

  public registerCar(addNewCarFormData) {
    this.AuthService.postAddCar(addNewCarFormData);
  }


  ngOnInit() {
    this.initForm()
  }

}
