import { Component, OnInit } from '@angular/core';
import { SortingService } from './sorting.service';
import { MatFormFieldModule, MatInputModule } from '@angular/material';
import { Sorting } from './sorting.model';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-sorting',
  templateUrl: './sorting.component.html',
  styleUrls: ['./sorting.component.scss']
})
export class SortingComponent implements OnInit {
  isFlag: boolean;
  sortValue: Sorting;
  sortForm: any;
  sortVal: string;
  beforeSort: string;
  afterSort: string;
  timeToSort: string;
  
  constructor(private sortingService: SortingService) { }

  ngOnInit() {
    this.isFlag = false;
    this.sortForm = new FormGroup({
       sortNumbers: new FormControl('', [Validators.required])
     });
  }

 sort() {
   console.log(this.sortForm.get('sortNumbers').value);
   this.sortVal = this.sortForm.get('sortNumbers').value;
   this.sortingService.getSortOrderList(this.sortVal).subscribe((response) => {
      this.sortValue = response;
      console.log(this.sortValue);
      // this.beforeSort = response.beforeSort;
      // this.afterSort =  response.afterSort;
      // this.timeToSort =  response.timeToSort;
    });
   this.isFlag = true;
 }
}
