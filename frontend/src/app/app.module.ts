import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {LoginComponent} from './components/login/login.component';
import {MainNavComponent} from './components/main-nav/main-nav.component';
import {LayoutModule} from '@angular/cdk/layout';
import {MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule} from '@angular/material';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NoopAnimationsModule} from "@angular/platform-browser/animations";
import {RegisterComponent} from './components/register/register.component';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatInputModule} from '@angular/material/input';
import {MaterialModule} from './shared/material/material.module'
import {HttpClientModule} from "@angular/common/http";
import {RoutingModule} from "../routing/routing.module"
import {FlexLayoutModule} from "@angular/flex-layout";
import { MainPageComponent } from './components/main-page/main-page.component';
import { FirstTimeDriverComponent } from './components/first-time-driver/first-time-driver.component';
import { MapComponent } from './components/map/map.component';
import{ AgmCoreModule } from "@agm/core";
import{ AgmDirectionModule } from "agm-direction";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainNavComponent,
    RegisterComponent,
    MainPageComponent,
    FirstTimeDriverComponent,
    MapComponent,
  ],
  imports: [
    BrowserModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatListModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatGridListModule,
    MatInputModule,
    MaterialModule,
    HttpClientModule,
    RoutingModule,
    MatIconModule,
    AgmCoreModule.forRoot({
      apiKey: ''
    }),
    AgmDirectionModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
