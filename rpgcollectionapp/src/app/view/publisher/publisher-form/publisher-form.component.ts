import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Publisher } from 'src/app/model/publisher';
import { PublisherService } from 'src/app/service/PublisherService/publisher.service';

@Component({
  selector: 'app-publisher-form',
  templateUrl: './publisher-form.component.html',
  styleUrls: ['./publisher-form.component.css']
})
export class PublisherFormComponent implements OnInit {
  publisherForm: FormGroup = this.formBuilder.group({
  name : [,{validators: [Validators.required, Validators.minLength(4)], updateOn:"change"}],
  website: [,{ updateOn:"change"}],
  imageUrl: [,{ updateOn:"change"}]
  })
  publisher: Publisher;

  constructor(private formBuilder: FormBuilder,
     private dialogRef: MatDialogRef<PublisherFormComponent>,
     @Inject(MAT_DIALOG_DATA) data: Publisher)
      {this.publisher = data }

  ngOnInit(): void {
    if(this.publisher != null){
      this.publisherForm.setValue({
        name: this.publisher.name,
        website: this.publisher.website,
        imageUrl: this.publisher.imageUrl
      })
    }
  }

  submitForm(){
   this.dialogRef.close(this.publisherForm.value)
  }

}
