import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const API_ROOT: string = "http://localhost:8080/book";

@Injectable({
  providedIn: 'root'
})
export class BookService {


  private
  constructor( private http: HttpClient ) {

   }

 getAll(): Observable<Book[]> {
    return this.http.get<Book>(API_ROOT);
  }
}

export interface Book {
  name: string;
  rating: string;
  description: string;
}
