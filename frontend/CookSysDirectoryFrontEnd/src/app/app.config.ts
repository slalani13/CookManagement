import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';

import { routes } from './app.routes';
import { UserService } from './user.service';
import { provideHttpClient } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
<<<<<<< Updated upstream
  providers: [provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes), provideHttpClient(),UserService]
=======
  providers: [provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes), provideHttpClient() ]
>>>>>>> Stashed changes
};
