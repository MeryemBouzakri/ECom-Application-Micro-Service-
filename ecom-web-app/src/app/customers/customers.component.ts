import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-cutomers',
  standalone: false,

  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  customers:any;
  constructor(private http:HttpClient ,
              private router:Router) {
  }
ngOnInit() {

    this.http.get("http://localhost:9999/CUSTOMER-SERVICE/api/customers").subscribe({
      next : (data)=>{
        this.customers=data;
      },
      error :(err)=>{}
    });
}

  getOrders(c:any) {
this.router.navigateByUrl("/orders/"+c.id);
  }
}
