import { Component } from '@angular/core';
import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private app: AuthService, private http: HttpClient, private router: Router) {
      this.app.authenticate(undefined, undefined);
    }

  logout() {
      this.http.post('logout', {}).subscribe(
      resp => { this.app.authenticated = false;
                      this.router.navigateByUrl('/login');
                      }
                      );

    }

}
