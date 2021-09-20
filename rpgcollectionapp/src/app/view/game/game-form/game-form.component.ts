import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { PublisherService } from 'src/app/service/PublisherService/publisher.service';
import { Publisher } from 'src/app/model/publisher';

@Component({
  selector: 'app-game-form',
  templateUrl: './game-form.component.html',
  styleUrls: ['./game-form.component.css']
})
export class GameFormComponent implements OnInit {
  name = new FormControl('',[Validators.required, Validators.minLength(6)]);
  description = new FormControl();

  public publishers: Publisher[] | undefined;
  constructor(private publisherService: PublisherService) {}

  ngOnInit():void {
    this.getPublishers();
  }

  getErrorMessage(){
    if(this.name.hasError('required'))
    return 'You must enter a value';    
  return !this.name.hasError('minLength') ? 'Name must be at least 6 characters long' : '';
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
  save(): void{}

close(): void{}
}
