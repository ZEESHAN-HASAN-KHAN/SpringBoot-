import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { MatDialog } from '@angular/material/dialog';
import { Movie } from '../movie';
import Swal from 'sweetalert2';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  displayedColumns: string[] = ['movieName','genre','leadActors','director','yearOfRelease','rating','actions'];
  movies: Movie[] = [];
  datasource = this.movies;

  constructor(private routerService : RouterService ,private authService: AuthenticationService, public dialog: MatDialog) {}

   ngOnInit(): void {
     this.fetchMovies();
   }

   addMovie(){
    this.routerService.routeToAddMovie();
    }

    deleteMovie(id: any): void {
      this.authService.deleteData(Math.round(id)).subscribe(
        (response) => {
          console.log(response);
          Swal.fire(
            'Success',
            'Movie Deleted Successfully',
            'success'
          )
          this.routerService.routeToMovies();
          this.fetchMovies();
        },
        (error) => {
          console.error('Error fetching movies:', error);
        }
      );
    }
  

    fetchMovies(): void {
      this.authService.getData().subscribe(
        (data) => {
          console.log(data);
          this.movies = data;
        },
        (error) => {
          console.error('Error fetching movies:', error);
        }
      );
    }
}

