import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'My Angular App';
  authenticatedUser : {email: string, name: string, id: string} | undefined;

  constructor(private _httpClient: HttpClient) {}

  ngOnInit(): void {
    this.getUsername();
    this.getAuthors();
  }

  getUsername() {
    this._httpClient.get("/users/self").subscribe(response => {
      this.authenticatedUser = response as {email: string, name: string, id: string};
    });
  }

  getAuthors() {
    this._httpClient.get("/authors/all").subscribe(response => {
      console.log(response);
    });
  }
}
