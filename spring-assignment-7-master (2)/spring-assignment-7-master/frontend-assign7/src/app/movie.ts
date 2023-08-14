export class Movie {
    movieId : number = Math.round(Math.random()*100000);
    movieName: string ='';
    genre: string='';
    leadActors:string[]=[];
    director: string='';
    yearOfRelease: number=0;
    rating: number=0;
  }
