import {Component, OnInit, ɵNgOnChangesFeature} from '@angular/core';
import {} from '@types/googlemaps';

@Component({
  selector: 'app-map-page',
  templateUrl: './map-page.component.html',
  styleUrls: ['./map-page.component.css']
})
export class MapPageComponent implements OnInit{


  public lat: Number = 44.439663;
  public lng: Number = 26.096306;


  ngOnInit() {

  }


}
