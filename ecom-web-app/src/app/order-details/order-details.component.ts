import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-order-details',
  standalone: false,

  templateUrl: './order-details.component.html',
  styleUrl: './order-details.component.css'
})
export class OrderDetailsComponent {
  orderDetails:any;
  orderId!:number;
  constructor(private http:HttpClient ,
              private router:Router,
              private route :ActivatedRoute) {
    this.orderId=route.snapshot.params['orderId'];
  }
  ngOnInit() {

    this.http.get("http://localhost:9999/BILLING-SERVICE/bills/"+this.orderId).subscribe({
      next : (data)=>{
        this.orderDetails=data;
      },
      error :(err)=>{}
    });
  }

  getOrderDetails(o: any) {
    this.router.navigateByUrl("/order-details/"+o.id);
  }
}
