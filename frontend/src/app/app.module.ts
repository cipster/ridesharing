
import { BrowserModule } from '@angular/platform-browser';
import { NgModule  } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MainNavComponent } from './main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule } from '@angular/material';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NoopAnimationsModule } from "@angular/platform-browser/animations";
import { RouterModule, Routes} from "@angular/router";
import { RegisterComponent } from './register/register.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule, MatFormFieldModule } from '@angular/material';
import { HttpClientModule } from "@angular/common/http";

const appRoutes :Routes = [

  { path : "login", component : LoginComponent },
  { path : "register", component : RegisterComponent },
  //{ path : "", redirectTo : "login", pathMatch : "full"}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainNavComponent,
    RegisterComponent,


  ],
  imports: [
    BrowserModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    RouterModule.forRoot(appRoutes),
    MatGridListModule,
    MatInputModule,
    MatCardModule,
    MatFormFieldModule,
    HttpClientModule


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
