import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Publisher } from 'src/app/model/publisher';
import { PublisherService } from 'src/app/service/PublisherService/publisher.service';
import { DeleteConfirmComponent } from '../delete-confirm/delete-confirm.component';
import { PublisherFormComponent } from './publisher-form/publisher-form.component';

@Component({
  selector: 'app-publisher',
  templateUrl: './publisher.component.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit {
  public publishers: Publisher[] | undefined;

  constructor(private publisherService: PublisherService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getPublishers();
  }

  getPublishers(): void{
    this.publisherService.getPublishers().subscribe(
      (response: Publisher[]) =>{
        this.publishers = response;
      }, error =>{
        alert(error.message);
      }
    )
  }

  addPublisherDialog(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    const dialogRef = this.dialog.open(PublisherFormComponent,dialogConfig);
    dialogRef.afterClosed().subscribe(
      data => {
      this.publisherService.addPublisher(data).subscribe(
        value =>
        {
          console.log('dodawanie dziala');
          this.getPublishers()
        }, error =>
        console.log('dodawanie nie dziala')
      );
      }, error =>
      console.log('nie dziala')
    )
  }
  updatePublisherDialog(publisher: Publisher){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = publisher;
    const dialogRef = this.dialog.open(PublisherFormComponent,dialogConfig);
    dialogRef.afterClosed().subscribe(
      data => {
      this.publisherService.updatePublisher(data, publisher.id).subscribe(
        value =>
        {
          console.log('updatowanie dziala');
          this.getPublishers()
        }, error =>
        console.log('updatowanie nie dziala')
      );
      }, error =>
      console.log('nie dziala')
    )
  }

  deletePublisherDialog(id: number | null){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    const dialogRef = this.dialog.open(DeleteConfirmComponent,dialogConfig)
    dialogRef.afterClosed().subscribe(
      data =>{
        if(data){
          this.publisherService.deletePublisher(id).subscribe(
            value =>{
              console.log("udalo sie usunąć");
              this.getPublishers();
            }, error =>
            console.log("nie udalo się usunąć wydawcy")
          )
        }
      },error=>
      console.log("cos nie dziala")
    )
  }

}
