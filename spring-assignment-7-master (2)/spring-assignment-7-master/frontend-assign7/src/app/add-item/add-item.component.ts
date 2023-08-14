import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Movie } from '../movie';
import { AuthenticationService } from '../services/authentication.service';
import Swal from 'sweetalert2';
import { RouterService } from '../services/router.service';


@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent {
  movies : Movie = new Movie();
  actors : string = '';
  constructor(private routerService : RouterService ,private authService: AuthenticationService) {}

  onSubmit(): void {
    this.movies.leadActors = this.actors.split(',');
    this.authService.postData(this.movies).subscribe(
      (response) => {
        if(response)
        {
          Swal.fire(
            'Success',
            'Movie Added Successfully',
            'success'
          )
          this.routerService.routeToMovies();
        }
      },
      (error: any) => {
        alert("New Movie Adding Error - "+error);
      }
    )
  }
}
