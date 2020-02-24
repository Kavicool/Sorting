import { Injectable } from '@angular/core';
import { Observable, throwError as observableThrowError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Sorting } from './sorting.model';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SortingService {

  constructor(private httpClient: HttpClient) {
  }

 getSortOrderList(sortNumbers: string): Observable<Sorting> {
   console.log(sortNumbers);
   return this.httpClient.get<Sorting>(`http://localhost:8080/sorting?sortNumbers=${sortNumbers}`);

   /* return this.httpClient.get<Sorting>(
        `/sorting?sortNumbers=${sortNumbers}`
      )
      .pipe(
        catchError((err: Response) => observableThrowError(err))
      ); */

 }

}
