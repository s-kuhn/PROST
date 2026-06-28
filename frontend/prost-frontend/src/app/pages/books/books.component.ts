import {Component, inject} from '@angular/core';
import {rxResource} from '@angular/core/rxjs-interop';

import {BookService} from '../../services/book.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent {
  private readonly bookService = inject(BookService);
  readonly books = rxResource({
    stream: () => this.bookService.listBooks(),
    defaultValue: []
  });
}
