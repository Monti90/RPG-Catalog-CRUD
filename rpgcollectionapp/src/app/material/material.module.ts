import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatButtonModule } from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox' ;
import {MatSliderModule} from '@angular/material/slider';
import {MatIconModule} from '@angular/material/icon';
import {MatBadgeModule} from '@angular/material/badge';
import {MatToolbarModule} from '@angular/material/toolbar'
import {MatCardModule} from '@angular/material/card'
import {MatInputModule} from '@angular/material/input'
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialogModule} from '@angular/material/dialog';
import {MatOptionModule} from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule } from '@angular/material/core';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatSelectModule} from '@angular/material/select';

const MaterialComponents = [
 MatButtonModule,
 MatCheckboxModule,
 MatSliderModule,
 MatIconModule,
 MatBadgeModule,
 MatToolbarModule,
 MatCardModule,
 MatInputModule,
 MatFormFieldModule,
 MatDialogModule,
 MatOptionModule,
 MatDatepickerModule,
 MatNativeDateModule,
 MatButtonToggleModule,
 MatSelectModule
];


@NgModule({
  declarations: [],
  imports: [
    MaterialComponents
  ],
  exports: [
    MaterialComponents
  ]
})
export class MaterialModule { }
