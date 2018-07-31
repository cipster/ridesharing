import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {RegisterComponent} from "../app/components/register/register.component";
import {LoginComponent} from "../app/components/login/login.component";
import {MainPageComponent} from "../app/components/main-page/main-page.component";
import {FirstTimeDriverComponent} from "../app/components/first-time-driver/first-time-driver.component";
import {MapComponent} from "../app/components/map/map.component";

const routes: Routes = [
  { path : "login", component : LoginComponent },
  { path : "register", component : RegisterComponent },
  { path : "first-time-screen", component : MainPageComponent },
  { path: "first-time-driver", component: FirstTimeDriverComponent},
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
