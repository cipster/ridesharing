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

  private brand:String;
  private model:String;
  private licensePlate:String;
  private year:number;
  private available:number;


  setBrand(event:any){
    this.brand= event.target.value;
  }

  setModel(event:any){
    this.model = event.target.value;
  }

  setLicensePlate(event:any){
    this.licensePlate = event.target.value;
  }

  setYear(event:any){
    this.year = event.target.value;
  }

  setAvailableSeats(event:any){
    this.available = event.target.value;
  }

  constructor(private auth:AuthService) { }

  ngOnInit() {
  }

  postAddCar() {
    this.carRegistrationData = {
      brand: this.brand,
      model: this.model,
      licensePlate: this.licensePlate,
      year: this.year,
      available: this.available,
    };

    this.auth.postAddCar(this.carRegistrationData)
  }
}
