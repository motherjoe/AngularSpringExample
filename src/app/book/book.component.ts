import { Component, OnInit } from '@angular/core';
import { BookService, Book } from '../book.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  books : Book[];

  constructor(private service : BookService) { }

  ngOnInit() {
    this.service.getAll()
      .subscribe((data: Book[]) => this.books = data );
  }


}
