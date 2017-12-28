import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-bill-amount',
  templateUrl: './bill-amount.component.html',
  styleUrls: ['./bill-amount.component.css']
})
export class BillAmountComponent implements OnInit {
  data: Object;
  loading: boolean;

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  calculateAmount() {
    this.loading = true;
    this.http.get('http://localhost:4567/tip', { responseType: 'text'})
               .subscribe( data => {
                            this.data = data;
                            this.loading = false;
    });
  }

}