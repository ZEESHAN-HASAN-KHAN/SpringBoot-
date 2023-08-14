import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { RouterService } from './services/router.service';
import { AuthenticationService } from './services/authentication.service';

@Injectable()
export class CanActivateGuard implements CanActivate {
  private bearertoken: string | null ;
  constructor(private routeService: RouterService, private authService: AuthenticationService) {
    this.bearertoken = (authService.getBearerToken());
  }

  canActivate(next: ActivatedRouteSnapshot,state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return new Promise<boolean>((resolve, reject) => {
        if (!this.authService.getBearerToken()) {
          reject(false);
          console.log("Bearer Token Error : Login Unauthorized , Token unavailable")
          this.routeService.routeTohome();
        } 
        else
        {
          resolve(true)
          console.log("Authentication succesful")
        }
      });
  }
}
