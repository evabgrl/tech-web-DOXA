import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root',
})
export class RoleGuard {
  constructor(private router: Router, private http: HttpClient) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean | UrlTree> {
    let role = route.data['role'] as string;
    return this.checkRole(role).pipe(
      map((hasRole) => {
        if (hasRole) {
          return true;
        } else {
          this.router.navigate(['/index']);
          this.fireModal();
          return false;
        }
      }),
      catchError(() => {
        this.router.navigate(['/index']);
        this.fireModal();
        return of(false);
      })
    );
  }

  private checkRole(role: string): Observable<boolean> {
    // Envoyer une requête HTTP pour vérifier si l'utilisateur a le rôle spécifié
    return this.http.get<boolean>('/api/check-role', {
      params: { role: role },
    });
  }

  private fireModal() {
    Swal.fire({
      icon: 'error',
      showConfirmButton: false,
      timer: 1500,
      background: '#7f5af0',
      color: 'white',
    });
  }
}
