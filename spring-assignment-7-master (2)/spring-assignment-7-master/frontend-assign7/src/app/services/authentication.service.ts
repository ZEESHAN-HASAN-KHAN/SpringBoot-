import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable,OnInit } from '@angular/core';
import { Observable, map } from 'rxjs';
import { user } from '../user';
import { Movie } from '../movie';
import { news } from '../news/news';
import { Blog } from '../blog';

@Injectable({
    providedIn: 'root'
})
export class AuthenticationService implements OnInit {
    token: any;
    url1: string;
    url2: string;
    url3: string;
    url4: string;
    constructor(private httpClient :HttpClient) {
      this.url1 = 'http://localhost:9000/api/v2/',
      this.url2 = 'http://localhost:9000/api/v1/',
      this.url3 = 'http://localhost:9000/api/v3/',
      this.url4 = 'http://localhost:9000/api/v4/'
    }
    ngOnInit(): void {
        
    }

    registerUser(data:user): Observable<any>{
        console.log(data);
        let headers = new HttpHeaders().set('content-Type','application/json');
        return this.httpClient.post(this.url1 + 'register',data,{headers});
    }

    loginUser(data:any): Observable<any>{
        return this.httpClient.post(this.url2 + "login",data).pipe(map((response:any) => 
        this.token = response.token
        ));
    }

    getBearerToken():string {
        return this.token;
        }

    getData(): Observable<any> {
        let headers = new HttpHeaders().set('Authorization', `Bearer ${this.getBearerToken()}`)
        let options = { headers: headers };
        console.log(this.getBearerToken());
        return this.httpClient.get<Array<any>>(this.url1 + "user/movies", options);    
      }

    postData(data : Movie) : Observable<any> {
        console.log(data);
        let headers = new HttpHeaders().set('Authorization', `Bearer ${this.getBearerToken()}`);
        return this.httpClient.post(this.url1 + 'user/movie',data,{headers});
    }
    
    deleteData(id : number) : Observable<any> {
        console.log(id);
        let headers = new HttpHeaders().set('Authorization', `Bearer ${this.getBearerToken()}`);
        return this.httpClient.delete(this.url1 + 'user/'+ id,{headers});
    }

    deleteNewsData(id : number) : Observable<any> {
        console.log(id);
        return this.httpClient.delete(this.url3 + 'news/'+ id);
    }

    getNewsData(): Observable<any> {
        return this.httpClient.get<Array<any>>(this.url3 + "newss");    
      }

    addNewsData(data : news): Observable<any> {
        console.log(data);
        return this.httpClient.post(this.url3 + 'news',data);
    }

    getBlogData(): Observable<any> {
        return this.httpClient.get<Array<any>>(this.url4 + "blogs");    
      }
    
    addBlogData(data: Blog): Observable<any> {
        console.log(data);
        return this.httpClient.post(this.url4 + 'blog',data);
    }

    deleteBlogData(id : number) : Observable<any> {
        console.log(id);
        return this.httpClient.delete(this.url4 + 'blog/'+ id);
    }
    editBlogData(body : Blog,id : number) : Observable<any> {
        console.log(id);
        console.log(this.url4 + 'blog/'+id);
        let headers = new HttpHeaders().set('content-Type','application/json');
        return this.httpClient.put(this.url4 + 'blog/'+ id, body,{headers});
    }
  }
