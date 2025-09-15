import {ArticleResource, TopHeadlinesResponse} from './top-headlines-response';
import {Article} from '../domain/model/article.entity';
import {LogoApi} from '../../shared/infrastructure/logo-api';

export class ArticleAssembler {
  static logoApi: LogoApi;
  static withLogoApi(logoApi: LogoApi) {
    this.logoApi = logoApi;
    return this;
  }
  static toEntityFromResource(resource: ArticleResource): Article {

    return {
      source: {
        id: resource.source.id || '',
        name: resource.source.name,
        url: '',
        urlToLogo: ''
      },
      title: resource.title,
      description: resource.description || '',
      url: resource.url,
      urlToImage: resource.urlToImage || '',
      publishedAt: resource.publishedAt
    };
  }

  static toEntitiesFromResponse(response: TopHeadlinesResponse): Article[] {
    return response.articles.map(article => this.toEntityFromResource(article));
  }
}
