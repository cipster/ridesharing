import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Injectable} from "@angular/core";
import {AuthService} from "./services/auth.service";
import { mergeMap } from 'rxjs/operators';
import {tap} from "rxjs/operators";

const skipRequests = (request: HttpRequest<any>) => {
  return true;
};

const isUnauthorized = (status: number) => status === 401;
const isForbidden = (status: number) => status === 403;

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

  constructor(private authService: AuthService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>{
    if (skipRequests(request)) {
      return next.handle(request);
    }

    return this.authService.getTokenFromStore$().pipe(mergeMap((token: string) => {
      return next.handle(request.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      }))
        .pipe(tap((event: HttpEvent<any>) => {
          if (event instanceof HttpResponse) {
            // do stuff with response if you want
          }
        }, (err: any) => {
          if (err instanceof HttpErrorResponse) {
            if (isUnauthorized(err.status)) {
              this.authService.logOut();
            } else if (isForbidden(err.status)) {
              // TODO some kind on on screen notification
              console.log('Access Denied! You are not allowed to access this resource');
            } else {
              // TODO some kind on on screen notification
              console.log(err.name, err.message);
            }
          }
        }));
    }));
  }
}
