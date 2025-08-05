import {HomeComponent} from "./pages/home/home.component";
import {Routes} from "@angular/router";
import {canActivateAuthRole} from './guards/auth.guard';
import {BooksComponent} from './pages/books/books.component';
import {UserProfileComponent} from './pages/user-profile/user-profile.component';
import {ForbiddenComponent} from './pages/forbidden/forbidden.component';
import {NotFoundComponent} from './pages/not-found/not-found.component';

export const routes: Routes = [
  {path: '', component: HomeComponent},
  {
    path: 'books',
    component: BooksComponent,
    canActivate: [canActivateAuthRole],
    data: {role: 'view-books'}
  },
  {
    path: 'profile',
    component: UserProfileComponent,
    canActivate: [canActivateAuthRole],
    data: {role: 'view-profile'}
  },
  {path: 'forbidden', component: ForbiddenComponent},
  {path: '**', component: NotFoundComponent}
];
