import { Component } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import Swal from 'sweetalert2';
import { RouterService } from '../services/router.service';
import { news, newslist } from '../news/news';

@Component({
  selector: 'app-add-news',
  templateUrl: './add-news.component.html',
  styleUrls: ['./add-news.component.css']
})
export class AddNewsComponent {
  news : news = new news;
  newsList : newslist = new newslist;
  constructor(private routerService : RouterService ,private authService: AuthenticationService) {}

  onSubmit(): void {
    this.news.newsList.push(this.newsList);
    console.log(this.news);
    this.authService.addNewsData(this.news).subscribe(
      (response) => {
        if(response)
        {
          Swal.fire(
            'Success',
            'News Added Successfully',
            'success'
          )
          this.routerService.routeToNews();
        }
      },
      (error: any) => {
        alert("New Movie Adding Error - "+error);
      }
    )
  }
}

