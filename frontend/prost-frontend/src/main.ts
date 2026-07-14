import {bootstrapApplication} from '@angular/platform-browser';
import {AppComponent} from './app/app.component';
import {loadRuntimeConfig} from './app/runtime-config';

loadRuntimeConfig()
.then(() => import('./app/app.config'))
.then(({appConfig}) => bootstrapApplication(AppComponent, appConfig))
.catch((err) => console.error(err));
