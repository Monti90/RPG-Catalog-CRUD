import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/UserService/user.service';
import { DeleteConfirmComponent } from '../delete-confirm/delete-confirm.component';
import { UserFormComponent } from './user-form/user-form.component';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
public users: User[] | undefined;

  constructor(private userService: UserService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getUsers();
  }

  public getUsers(): void{
    this.userService.getUsers().subscribe(
      (response: User[]) => {
        this.users = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  addUserDialog(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.height='400px';
    dialogConfig.width='600px';
    const dialogRef = this.dialog.open(UserFormComponent,dialogConfig);
    dialogRef.afterClosed().subscribe(
      data => {
      this.userService.addUser(data).subscribe(
        value =>
        {
          console.log('dodawanie dziala');
          this.getUsers()
        }, error =>
        console.log('dodawanie nie dziala')
      );
      }, error =>
      console.log('nie dziala')
    )
  }
  updateUserDialog(user: User){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.height='400px';
    dialogConfig.width='600px';
    dialogConfig.data = user;
    const dialogRef = this.dialog.open(UserFormComponent,dialogConfig);
    dialogRef.afterClosed().subscribe(
      data => {
      this.userService.updateUser(data, user.id).subscribe(
        value =>
        {
          console.log('updatowanie dziala');
          this.getUsers()
        }, error =>
        console.log('updatowanie nie dziala')
      );
      }, error =>
      console.log('nie dziala')
    )
  }

  deleteUserDialog(id: number | null){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    const dialogRef = this.dialog.open(DeleteConfirmComponent,dialogConfig)
    dialogRef.afterClosed().subscribe(
      data =>{
        if(data){
          this.userService.deleteUser(id).subscribe(
            value =>{
              console.log("udalo sie usunąć");
              this.getUsers();
            }, error =>
            console.log("nie udalo się usunąć użytkownika")
          )
        }
      },error=>
      console.log("cos nie dziala")
    )
  }

}
