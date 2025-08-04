import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {MenuComponent} from './pages/menu/menu.component';
import {FaviconService} from './services/favicon.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MenuComponent],
  templateUrl: './app.component.html',
  styles: [``]
})
export class AppComponent {
  constructor(private faviconService: FaviconService) {
    // The service is automatically initialized and restores the favicon
  }
}
