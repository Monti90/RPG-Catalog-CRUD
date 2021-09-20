import { Component, OnInit } from '@angular/core';
import { Game } from '../../model/game';
import { GameService } from 'src/app/service/GameService/game.service';
import { HttpErrorResponse } from '@angular/common/http';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { GameFormComponent } from './game-form/game-form.component';
import { DeleteConfirmComponent } from '../delete-confirm/delete-confirm.component';
import { PublisherService } from 'src/app/service/PublisherService/publisher.service';
import { Publisher } from 'src/app/model/publisher';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  public games: Game[] | undefined;
  constructor(private gameService: GameService, private dialog: MatDialog){}

  ngOnInit(){
    this.getGames();
  }

  public getGames(): void{
    this.gameService.getGames().subscribe(
      (response: Game[]) => {
        this.games = response;
      },
      (error: HttpErrorResponse) => {
        alert(error);
        console.log(error);
      }
    )
  }
//FIX - move it to forms and take values from the form
  public addGame(): void{
    this.gameService.addGame({id: null, name: 'Inna gra', price: 249.99, description: 'jakiśtam długi opis',
     author: 'Adam Wieczorek', genre: 'Horror', category: 'Scenariusze', publisherID: 1, userID: 0}).subscribe(
       value => {
         this.getGames()
         console.log('dziala');
       }, error => {
         console.log("nie dziala");
       }
     )
  }
  
  deleteGameDialog(id: number | null){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    const dialogRef = this.dialog.open(DeleteConfirmComponent,dialogConfig)
    dialogRef.afterClosed().subscribe(
      data =>{
        if(data){
          this.gameService.deleteGame(id).subscribe(
            value =>{
              console.log("udalo sie usunąć grę");
              this.getGames();
            }, error =>
            console.log("nie udalo się usunąć gry")
          )
        }
      },error=>
      console.log("cos nie dziala")
    )
  }
  
}
