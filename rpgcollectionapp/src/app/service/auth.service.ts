import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const AUTH_API = 'http://localhost:8080/authenticate';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

 login(credentials: { username: any; password: any; }): Observable<any>{
   return this.http.post(AUTH_API,{
     username: credentials.username,
     password: credentials.password
   }, httpOptions);
 }

}
