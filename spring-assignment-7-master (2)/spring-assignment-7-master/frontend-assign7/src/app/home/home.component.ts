import { Component } from '@angular/core';
import { RouterService } from '../services/router.service';
import { user } from '../user';
import Swal from 'sweetalert2';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private routerService : RouterService , private authService : AuthenticationService){};
  newUser : user = new user();
  hide = true;
  email:string='';
  password:string='';

  onSubmit(){
    const requestParams = {
      email : this.newUser.email,
      password : this.newUser.password
    };
    if(!requestParams) 
      alert('Both fields are necessary');
    else{
      this.authService.loginUser(requestParams).subscribe((map) => {
          if(map)
          {
            Swal.fire(
              'Login',
              'Login Successful',
              'success'
            )
            this.routerService.routeToMovies();  
          }
          else{
            alert("No response from server : Internal Servor error");
          }
        }
      )
    }
  }



}
