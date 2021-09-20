import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { GameService } from './service/GameService/game.service';
import { HttpClientModule } from '@angular/common/http';
import { GameComponent } from './view/game/game.component';
import { UsersComponent } from './users/users.component';
import { RouterModule } from '@angular/router';
import { PublisherComponent } from './view/publisher/publisher.component';
import { PageNotFoundComponent } from './view/page-not-found/page-not-found.component';
import { GameFormComponent } from './view/game/game-form/game-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DeleteConfirmComponent } from './view/delete-confirm/delete-confirm.component';
import { PublisherFormComponent } from './view/publisher/publisher-form/publisher-form.component';
import { UserComponent } from './view/user/user.component';
import { UserFormComponent } from './view/user/user-form/user-form.component';
import { LoginComponent } from './jwt/login/login.component';
import { RegisterComponent } from './jwt/register/register.component';
import { HomeComponent } from './jwt/home/home.component';
import { ProfileComponent } from './jwt/profile/profile.component';
import { BoardAdminComponent } from './jwt/board-admin/board-admin.component';
import { BoardModeratorComponent } from './jwt/board-moderator/board-moderator.component';
import{authInterceptorProviders} from './_helpers/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    GameComponent,
    PublisherComponent,
    PageNotFoundComponent,
    GameFormComponent,
    DeleteConfirmComponent,
    PublisherFormComponent,
    UserComponent,
    UserFormComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {path: 'game', component: GameComponent},
      {path: 'users', component: UserComponent},
      {path: 'publisher', component: PublisherComponent},
      {path: '', component: AppComponent},
      {path: 'login', component: LoginComponent}
    ]
    )
  ],
  providers: [GameService, authInterceptorProviders],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
