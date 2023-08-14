export class newslist {
    newsId : number = 0;
    title : string = "";
    author : string = "";
    description : string = "";
    publishedAt : string = "";
    content : string = "";
    url : string = "";
}

export class news {
    userId : number = 0;
    newsList : newslist[]  = [];
}