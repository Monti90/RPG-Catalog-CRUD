import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiServerUrl =  environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public getUsers(): Observable<User[]>{
   return this.http.get<User[]>(`${this.apiServerUrl}/user`);
  }
  public getUserById(userId: number | null): Observable<User>{
   return this.http.get<User>(`${this.apiServerUrl}/user/${userId}`); 
  }
  public addUser(user: User): Observable<User>{
    return this.http.post<User>(`${this.apiServerUrl}/user`,user);
  }
  public updateUser(user: User, userId: number | null): Observable<User>{
    return this.http.put<User>(`${this.apiServerUrl}/user/${userId}`, user);
  }
  public deleteUser(userId: number | null): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/user/${userId}`);
  }
}
