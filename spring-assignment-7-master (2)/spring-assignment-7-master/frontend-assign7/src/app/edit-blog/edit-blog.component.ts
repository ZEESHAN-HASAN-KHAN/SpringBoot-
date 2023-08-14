import { Component, Input } from '@angular/core';
import { Blog } from '../blog';
import { AuthenticationService } from '../services/authentication.service';
import { RouterService } from '../services/router.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-blog',
  templateUrl: './edit-blog.component.html',
  styleUrls: ['./edit-blog.component.css']
})
export class EditBlogComponent {

  constructor(private route: ActivatedRoute,private authService:AuthenticationService,private routerService:RouterService){
  }

  id: number = this.route.snapshot.params['id'];
  newBlog : Blog = new Blog;
  
  updateBlog(data:Blog) {
      this.authService.editBlogData(data,this.id).subscribe(
      (response) => {
        console.log(response);
        this.routerService.routeToBlogs();
      },
      (error) => {
        console.error('Error editing blog:', error);
      }
    );
  }
}
