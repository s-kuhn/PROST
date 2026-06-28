import {Component, computed, inject} from '@angular/core';
import {RouterModule} from '@angular/router';
import Keycloak from 'keycloak-js';
import {HasRolesDirective, KEYCLOAK_EVENT_SIGNAL, KeycloakEventType, ReadyArgs, typeEventArgs} from 'keycloak-angular';

@Component({
  selector: 'app-menu',
  imports: [RouterModule, HasRolesDirective],
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {
  private readonly keycloak = inject(Keycloak);
  private readonly keycloakSignal = inject(KEYCLOAK_EVENT_SIGNAL);

  readonly keycloakStatus = computed(() => this.keycloakSignal().type);
  readonly authenticated = computed(() => {
    const keycloakEvent = this.keycloakSignal();

    if (keycloakEvent.type === KeycloakEventType.Ready) {
      return typeEventArgs<ReadyArgs>(keycloakEvent.args);
    }

    if (keycloakEvent.type === KeycloakEventType.AuthLogout) {
      return false;
    }

    return this.keycloak.authenticated ?? false;
  });

  login(): void {
    this.keycloak.login();
  }

  logout(): void {
    this.keycloak.logout();
  }
}
