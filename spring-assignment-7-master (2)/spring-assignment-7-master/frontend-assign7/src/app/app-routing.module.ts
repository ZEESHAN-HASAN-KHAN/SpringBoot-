import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CanActivateGuard } from './can-activate.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RegisterComponent } from './register/register.component';
import { MoviesComponent } from './movies/movies.component';
import { NewsComponent } from './news/news.component';
import { AddItemComponent } from './add-item/add-item.component';
import { AddNewsComponent } from './add-news/add-news.component';
import { AddBlogComponent } from './add-blog/add-blog.component';
import { BlogComponent } from './blog/blog.component';
import { EditBlogComponent } from './edit-blog/edit-blog.component';

const routes: Routes = [
  {
    path:'',
    redirectTo:"home",
    pathMatch:'full'
  },
{
  path: "login",
  component : HomeComponent
},
{
  path:"register",
  component:RegisterComponent
},
{
  path:"movies",
  component:MoviesComponent
},
{
  path:"news",
  component:NewsComponent
},
{
  path:"home",
  component:NewsComponent
},
{
  path:"add-movie",
  component:AddItemComponent
},
{
  path:"add-news",
  component:AddNewsComponent
},
{
  path:"add-blog",
  component:AddBlogComponent
},
{
  path:"blogs",
  component:BlogComponent
},
{
  path:"edit-blog/:id",
  component:EditBlogComponent
}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
