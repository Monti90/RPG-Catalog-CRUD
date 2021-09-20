import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Game } from 'src/app/model/game';
import { environment } from 'src/environments/environment';
import { FormGroup,FormControl } from '@angular/forms';
  
  @Injectable({providedIn: 'root'})
  export class GameService {
    private apiServerUrl =  environment.apiBaseUrl;

    constructor(private http: HttpClient) { }
    public getGames(): Observable<Game[]> {
      return this.http.get<Game[]>(`${this.apiServerUrl}/game`);
    }
    public getGameById(gameId: number): Observable<Game> {
      return this.http.get<Game>(`${this.apiServerUrl}/game/${gameId}`);
    }
    public getGamesByPublisher(publisherId: number): Observable<Game[]> {
      return this.http.get<Game[]>(`${this.apiServerUrl}/game/byPublisher/${publisherId}`);
    }
    public getGamesByUser(userId: number): Observable<Game[]> {
      return this.http.get<Game[]>(`${this.apiServerUrl}/game/byUser/${userId}`);
    }
    public getGamesByAuthor(author: string): Observable<Game[]> {
      return this.http.get<Game[]>(`${this.apiServerUrl}/game/byAuthor?author=${author}`);
    }
    public getGamesByGenre(genre: string): Observable<Game[]> {
      return this.http.get<Game[]>(`${this.apiServerUrl}/game/byGenre?genre=${genre}`);
    }
    public getGamesByCategory(category: string): Observable<Game[]> {
      return this.http.get<Game[]>(`${this.apiServerUrl}/game/byCategory?category=${category}`);
    }
    public addGame(game: Game): Observable<Game> {
      return this.http.post<Game>(`${this.apiServerUrl}/game`,game);
    }
    public updateGame(game: Game, gameId: number | null): Observable<Game> {
      return this.http.put<Game>(`${this.apiServerUrl}/game/${gameId}`,game);
    }

    public deleteGame(gameId: number | null): Observable<void> {
      return this.http.delete<void>(`${this.apiServerUrl}/game/${gameId}`);
    }

}
