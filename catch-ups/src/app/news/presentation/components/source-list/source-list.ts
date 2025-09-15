import {Component, input, output} from '@angular/core';
import {Source} from '../../../domain/model/source.entity';
import {MatNavList} from '@angular/material/list';
import {SourceItem} from '../source-item/source-item';

@Component({
  selector: 'app-source-list',
  imports: [
    MatNavList,
    SourceItem
  ],
  templateUrl: './source-list.html',
  styleUrl: './source-list.css'
})
export class SourceList {
  sources = input<Source[]>();
  sourceSelected = output<Source>();

  emitSourceSelectedEvent(source: Source) {
    this.sourceSelected.emit(source);
  }
}
