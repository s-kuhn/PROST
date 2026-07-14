import {Component, OnDestroy, signal} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterLink} from '@angular/router';
import {getRuntimeConfig} from '../../runtime-config';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css'],
    imports: [CommonModule, RouterLink]
})
export class HomeComponent implements OnDestroy {
    readonly url = getRuntimeConfig().keycloak.url;
    readonly copyMessage = signal<string | null>(null);
    private copyMessageTimeout: ReturnType<typeof setTimeout> | undefined;

    copyToClipboard(text: string): void {
        navigator.clipboard
            .writeText(text)
            .then(() => {
                this.copyMessage.set(`"${text}" copied to clipboard!`);
                this.clearCopyMessageTimeout();
                this.copyMessageTimeout = setTimeout(() => this.copyMessage.set(null), 3000);
            })
            .catch(() => {
                this.copyMessage.set('Failed to copy text. Please try again.');
            });
    }

    ngOnDestroy(): void {
        this.clearCopyMessageTimeout();
    }

    private clearCopyMessageTimeout(): void {
        if (this.copyMessageTimeout !== undefined) {
            clearTimeout(this.copyMessageTimeout);
            this.copyMessageTimeout = undefined;
        }
    }
}
