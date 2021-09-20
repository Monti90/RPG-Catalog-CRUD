import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Publisher } from 'src/app/model/publisher';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PublisherService {
  private apiServerUrl =  environment.apiBaseUrl;

  constructor(private http: HttpClient) { }
public getPublishers(): Observable<Publisher[]> {
  return this.http.get<Publisher[]>(`${this.apiServerUrl}/publisher`);
}
public getPublisheById(publisherId: number | null): Observable<Publisher> {
  return this.http.get<Publisher>(`${this.apiServerUrl}/publisher/${publisherId}`);
}
public addPublisher(publisher: Publisher): Observable<Publisher>{
  return this.http.post<Publisher>(`${this.apiServerUrl}/publisher`,publisher);
}
public updatePublisher(publisher: Publisher, publisherId: number | null): Observable<Publisher>{
  return this.http.put<Publisher>(`${this.apiServerUrl}/publisher/${publisherId}`, publisher);
}
public deletePublisher(publisherId: number | null): Observable<void>{
  return this.http.delete<void>(`${this.apiServerUrl}/publisher/${publisherId}`);
}
}
