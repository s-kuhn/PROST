import {ApplicationConfig, inject, provideEnvironmentInitializer, provideZonelessChangeDetection} from '@angular/core';
import {routes} from './app.routes';
import {provideRouter} from '@angular/router';
import {provideKeycloakAngular} from './keycloak.config';
import {provideHttpClient, withInterceptors, withXhr} from '@angular/common/http';
import {includeBearerTokenInterceptor} from 'keycloak-angular';
import {FaviconService} from './services/favicon.service';

export const appConfig: ApplicationConfig = {
  providers: [
    provideKeycloakAngular(),
    provideZonelessChangeDetection(),
    provideRouter(routes),
      // TODO: withXhr() / withFetch()
    provideHttpClient(withXhr(), withInterceptors([includeBearerTokenInterceptor])),
    provideEnvironmentInitializer(() => {
      inject(FaviconService);
    })
  ],
};
