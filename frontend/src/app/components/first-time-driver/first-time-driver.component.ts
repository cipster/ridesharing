import { Component, OnInit } from '@angular/core';
import { CarRegistrationData } from "../../interfaces/car-registration-data"
import {AuthService} from "../../services/auth.service";
import {a} from "@angular/core/src/render3";


@Component({
  selector: 'app-first-time-driver',
  templateUrl: './first-time-driver.component.html',
  styleUrls: ['./first-time-driver.component.css']
})
export class FirstTimeDriverComponent implements OnInit {

  private carRegistrationData: CarRegistrationData;


  constructor(private auth:AuthService) { }

  ngOnInit() {
  }

  postAddCar() {
    console.log("ceva");
    this.carRegistrationData = {
      brand: "asd",
      model: "asd",
      licensePlate: "asd",
      year: 0,
      available:0,
    };

    this.auth.postAddCar(this.carRegistrationData)
  }
}
