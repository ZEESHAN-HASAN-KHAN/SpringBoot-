import { Component, OnInit } from '@angular/core';
import { news, newslist } from './news';
import { MatDialog } from '@angular/material/dialog';
import { AuthenticationService } from '../services/authentication.service';
import { RouterService } from '../services/router.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-news-blog',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit{
  constructor(private routerService : RouterService ,private authService: AuthenticationService, public dialog: MatDialog) {}
  news : news[] = [];
  newslist : newslist = new newslist;

  ngOnInit(): void {
    this.fetchNews();
  }
  
  deleteNews(id: any): void {
    this.authService.deleteNewsData(id).subscribe(
      (response) => {
        console.log(response);
        Swal.fire(
          'Success',
          'News Deleted Successfully',
          'success'
        )
        this.routerService.routeToNews();
        this.fetchNews();
      },
      (error) => {
        console.error('Error fetching news:', error);
      }
    );
  }

  fetchNews(): void {
    this.authService.getNewsData().subscribe(
      (data) => {
        console.log(data);
        this.news = data;
        this.newslist = data;
        console.log(this.newslist);
      },
      (error) => {
        console.error('Error fetching news:', error);
      }
    );
  }

  displayedColumns: string[] = ['userId','newsId','title','author','description','publishedAt','content','url','delete'];
}
