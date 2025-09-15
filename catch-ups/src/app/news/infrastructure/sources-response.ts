export interface SourcesResponse {
  status: string;
  sources: SourceResource[];
}

export interface SourceResource {
  id: string;
  name: string;
  url: string;
  urlToLogo: string;
}
