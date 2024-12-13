import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-orders',
  standalone: false,

  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css'
})
export class OrdersComponent {
  bills :any;
  customerId!:number;
  constructor(private http:HttpClient ,
              private router:Router,
             private route :ActivatedRoute) {
    this.customerId=route.snapshot.params['customerId'];
  }
  ngOnInit() {

    this.http.get("http://localhost:9999/BILLING-SERVICE/bills/search/bycustomerId?projection=FullBills=&customerId="+this.customerId).subscribe({
      next : (data)=>{
        this.bills=data;
      },
      error :(err)=>{}
    });
  }

  getOrderDetails(b: any) {
    this.router.navigateByUrl("/order-details/"+b.id);
  }
}
