import { Component, OnInit, Output } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Blog } from '../blog';
import { RouterService } from '../services/router.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit{
  constructor(private router: Router,private authService : AuthenticationService,private routerService:RouterService){
  }

  ngOnInit(): void {
    this.fetchBlogs();
  }

  blogs: Blog[] = [];


  editBlog(id:number):void{
    this.router.navigate(['/edit-blog',id]);
  }

  deleteBlog(id:number):void{
    this.authService.deleteBlogData(id).subscribe(
      (response) => {
        console.log(response);
        this.fetchBlogs();
      },
      (error) => {
        console.error('Error deleting blogs:', error);
      }
    )
  }
  
  fetchBlogs() : void{
    this.authService.getBlogData().subscribe(
      (data) => {
        console.log(data);
        this.blogs = data;
      },
      (error) => {
        console.error('Error fetching blogs:', error);
      }
    );
  }

}

