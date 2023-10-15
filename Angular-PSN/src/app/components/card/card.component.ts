import {Input, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input()
  gameCover:String=""
  @Input()
  gameType:String="Digital PS4"
  @Input()
  gamePrice:String="R$ 399,90"
  @Input()
  gameLabel:String=""
  constructor() { }

  ngOnInit(): void {
  }

}
