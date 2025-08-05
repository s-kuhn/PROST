import {effect, inject, Injectable} from '@angular/core';
import {KEYCLOAK_EVENT_SIGNAL, KeycloakEventType} from 'keycloak-angular';

@Injectable({
  providedIn: 'root'
})
export class FaviconService {
  private originalFavicon = 'assets/tab-logo.png';
  private readonly keycloakSignal = inject(KEYCLOAK_EVENT_SIGNAL);

  constructor() {
    this.setFavicon(this.originalFavicon);
    this.setupKeycloakEventListeners();
  }

  private setupKeycloakEventListeners(): void {
    effect(() => {
      const keycloakEvent = this.keycloakSignal();

      if (keycloakEvent.type === KeycloakEventType.AuthSuccess ||
        keycloakEvent.type === KeycloakEventType.AuthLogout ||
        keycloakEvent.type === KeycloakEventType.AuthRefreshSuccess) {
        setTimeout(() => {
          this.restoreOriginalFavicon();
        }, 100);
      }
    });

    window.addEventListener('focus', () => {
      this.restoreOriginalFavicon();
    });
  }

  setFavicon(faviconUrl: string): void {
    const link: HTMLLinkElement = document.querySelector("link[rel*='icon']") || document.createElement('link');
    link.type = 'image/png';
    link.rel = 'icon';
    link.href = faviconUrl;
    document.getElementsByTagName('head')[0].appendChild(link);
  }

  restoreOriginalFavicon(): void {
    this.setFavicon(this.originalFavicon);
  }
}
