import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';
import { authCodeFlowConfig } from './config/authCodeFlowConfig';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularOAuth2Demo';

  constructor(private oauthService: OAuthService,
    private _http: HttpClient
  ) {
    this.oauthService.configure(authCodeFlowConfig);
    this.oauthService.loadDiscoveryDocumentAndTryLogin();
  }

  login() {
    this.oauthService.initCodeFlow();
  }

  logout() {
    this.oauthService.logOut();
  }

  get name () {
    const claims = this.oauthService.getIdentityClaims();
    if (!claims) return null;
    const nameClaim = claims as {name: string};
    return nameClaim.name;
  }

  getAuthors() {
    this._http.get("http://localhost:8080/authors/all")
      .toPromise()
      .then(console.log)
      .catch(console.error);
  }

}
