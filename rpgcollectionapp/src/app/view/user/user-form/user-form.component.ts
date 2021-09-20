import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/UserService/user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  //Properties
  hide = true;
  roles: string[] = ['USER', 'ADMIN'];
  reg = new RegExp("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$")
  user: User;

  constructor(
    private formBuilder: FormBuilder,
     private userService: UserService,
       private dialogRef: MatDialogRef<UserFormComponent>, @Inject(MAT_DIALOG_DATA) data: User) { 
         this.user = data;
       }


  userForm: FormGroup = this.formBuilder.group({
   userName:[,{validators: [Validators.required, Validators.minLength(4)], updateOn:"change"}],
   userPassword: [,{validators: [Validators.required, Validators.minLength(8), Validators.pattern(this.reg)], updateOn:"change"}],
   email: [,{validators: [Validators.required, Validators.email], updateOn:"change"}],
   role: [,{updateOn:"change"}]
  })


  ngOnInit(): void {
    if(this.user != null){
    this.userForm.setValue({
      userName: this.user.userName,
      userPassword: '',
      email: this.user.email,
      role: this.user.role
    }
    )
  }
  }

  submitForm(){
    this.dialogRef.close(this.userForm.value);
  }
}
