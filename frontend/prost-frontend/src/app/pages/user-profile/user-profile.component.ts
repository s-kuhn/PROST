import {Component, inject, resource} from '@angular/core';
import {User} from '../../models/user.model';
import Keycloak from 'keycloak-js';

@Component({
  selector: 'app-user-profile',
  templateUrl: 'user-profile.component.html',
  styleUrls: [`user-profile.component.css`]
})
export class UserProfileComponent {
  private readonly keycloak = inject(Keycloak);

  readonly user = resource<User | undefined, void>({
    loader: async () => {
      if (!this.keycloak.authenticated) {
        return undefined;
      }

      const profile = await this.keycloak.loadUserProfile();

      return {
        name: `${profile.firstName ?? ''} ${profile.lastName ?? ''}`.trim(),
        email: profile.email,
        username: profile.username
      };
    }
  });
}
