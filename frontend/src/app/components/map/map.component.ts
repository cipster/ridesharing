import { Component, OnInit } from '@angular/core';
import {} from '@types/googlemaps';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  constructor() { }

  public lat: Number = 44.439663;
  public lng: Number = 26.096306;

  ngOnInit() {
  }

}
