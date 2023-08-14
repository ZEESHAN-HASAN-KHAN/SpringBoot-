import { Component } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import Swal from 'sweetalert2';
import { RouterService } from '../services/router.service';
import { Blog } from '../blog';

@Component({
  selector: 'app-add-blog',
  templateUrl: './add-blog.component.html',
  styleUrls: ['./add-blog.component.css']
})
export class AddBlogComponent {
  
  constructor(private authService: AuthenticationService,private routerService: RouterService){

  }
  newBlog: Blog = new Blog;

  submitBlog(): void {
    console.log(this.newBlog);
    this.authService.addBlogData(this.newBlog).subscribe(
      (response) => {
        if(response)
        {
          Swal.fire(
            'Success',
            'Blog Added Successfully',
            'success'
          )
          this.routerService.routeToBlogs();
        }
      },
      (error: any) => {
        alert("New Blog Adding Error - "+error);
      }
    )
  }
}
