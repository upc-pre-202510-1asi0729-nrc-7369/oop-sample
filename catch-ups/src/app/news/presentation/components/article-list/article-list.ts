import {Component, input} from '@angular/core';
import {Article} from '../../../domain/model/article.entity';
import {ArticleItem} from '../article-item/article-item';

@Component({
  selector: 'app-article-list',
  imports: [
    ArticleItem
  ],
  templateUrl: './article-list.html',
  styleUrl: './article-list.css'
})
export class ArticleList {
  articles = input.required<Array<Article>>();
}
