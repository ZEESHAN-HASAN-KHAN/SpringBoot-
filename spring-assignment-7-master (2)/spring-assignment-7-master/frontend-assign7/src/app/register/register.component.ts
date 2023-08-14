import { Component,OnInit } from '@angular/core';
import { user } from '../user';
import { AuthenticationService } from '../services/authentication.service';
import { RouterService } from '../services/router.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private authenticationService : AuthenticationService ,private routerService  : RouterService){}

  ngOnInit(): void {
    
  }

  hide = true;
  newUser : user = new user();

  onSubmit(){
      if(!this.newUser.userName || !this.newUser.password || !this.newUser.email || !this.newUser.phoneNumber)
      {
        alert("All fields are necessary");
      }
      else{
        console.log(this.newUser);
        this.authenticationService.registerUser(this.newUser).subscribe(
          (response) => {
            if(response)
            {
              Swal.fire(
                'Success',
                'Register Successful',
                'success'
              )
              this.routerService.routeTohome();
            }
          },
          (error: any) => {
            alert("New User Register Error - "+error);
          }
        )
      }
  }

}
