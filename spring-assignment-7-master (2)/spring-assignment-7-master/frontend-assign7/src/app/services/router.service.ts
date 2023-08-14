import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable()
export class RouterService {

  constructor(private router: Router) { }

  routeTohome() {
    this.router.navigate(['home']);
  }

  routeToMovies(){
    this.router.navigate(['movies']);
  }

  routeToNews(){
    this.router.navigate(['news']);
  }
  
  routeToAddMovie(){
    this.router.navigate(['add-movie']);
  }

  routeToAddNews(){
    this.router.navigate(['add-news']);
  }

  routeToAddBlogs(){
    this.router.navigate(['add-blog']);
  }

  routeToBlogs(){
    this.router.navigate(['blogs']);
  }
  
  routeToEditBlogs(){
    this.router.navigate(["edit-blog"]);
  }

}