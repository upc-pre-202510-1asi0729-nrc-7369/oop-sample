import {computed, inject, Injectable, signal} from '@angular/core';
import {Source} from '../domain/model/source.entity';
import {Article} from '../domain/model/article.entity';
import {NewsApi} from '../infrastructure/news-api';
import {LogoApi} from '../../shared/infrastructure/logo-api';

@Injectable({providedIn: 'root'})
export class NewsStore {


  private sourcesSignal = signal<Source[]>([]);
  private articlesSignal = signal<Record<string, Article[]>>({});
  private newsApi = inject(NewsApi);
  private logoApi = inject(LogoApi);

  readonly sources = computed(() => this.sourcesSignal());
  readonly articles = computed(() => this.articlesSignal());
  public currentSourceArticles = computed(() => this.articlesSignal()[this.currentSource?.id] ?? []);
  private _currentSource!: Source;

  loadSources() {
    if (this.sourcesSignal().length === 0) {
      this.newsApi.getSources().subscribe(sources => {
        sources.forEach(source => source.urlToLogo = this.logoApi.getUrlToLogo(source));
        this.sourcesSignal.set(sources);
        this.currentSource = sources[0];
        this.loadArticlesForCurrentSource();
      });
    }
  }

  loadArticlesForCurrentSource() {
    console.log(this.currentSource);
    const current = this.articlesSignal() ?? {};
    const source = this._currentSource;
    if (!current[source.id]) {
      this.newsApi.getArticlesBySourceId(source.id).subscribe(articles => {
        articles.forEach(article => {
          article.source.urlToLogo = source.urlToLogo;
          article.source.url = source.url;
        });
        this.articlesSignal.set({ ...current, [source.id]: articles });
      });
    }
  }

  get currentSource(): Source {
    return this._currentSource;
  }

  set currentSource(value: Source) {
    this._currentSource = value;
    this.loadArticlesForCurrentSource();
  }

}
