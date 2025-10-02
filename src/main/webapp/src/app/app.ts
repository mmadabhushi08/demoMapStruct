import { Component} from '@angular/core';
import { RouterOutlet, RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,
    RouterModule
  ],
  templateUrl: './app.html',
  styleUrl: './app.scss',
  standalone: true
})
export class App {
  //protected readonly title = signal('hello-world MM');

  title: string;

  constructor() {
    this.title = 'Spring Boot - Angular UI';
  }
}
