import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {RegisterComponent} from "../app/components/register/register.component";
import {LoginComponent} from "../app/components/login/login.component";
import {MainPageComponent} from "../app/components/main-page/main-page.component";
import {AddNewCarComponent} from "../app/components/add-new-car/add-new-car.component";
import {MapComponent} from "../app/components/map/map.component";

const routes: Routes = [
  { path : "login", component : LoginComponent },
  { path : "register", component : RegisterComponent },
  { path : "first-time-screen", component : MainPageComponent },
  { path: "add-new-car", component: AddNewCarComponent},
  { path: "map", component: MapComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [
    RouterModule
  ]
})
export class RoutingModule { }
