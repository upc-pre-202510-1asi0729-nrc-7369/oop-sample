import {Component, input, output} from '@angular/core';
import {Source} from '../../../domain/model/source.entity';
import {MatListItem} from '@angular/material/list';

@Component({
  selector: 'app-source-item',
  imports: [
    MatListItem
  ],
  templateUrl: './source-item.html',
  styleUrl: './source-item.css'
})
export class SourceItem {
  source = input.required<Source>();
  sourceSelected = output<Source>();

  emitSourceSelectedEvent() {
    this.sourceSelected.emit(this.source());
  }

}
