import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

import {Book} from '../models/book.model';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private apiUrl = environment.apiUrl + '/v1/test';
  private http = inject(HttpClient);

  listBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.apiUrl);
  }
}
