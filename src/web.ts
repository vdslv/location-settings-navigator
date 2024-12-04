import { WebPlugin } from '@capacitor/core';

import type { LocationSettingsNavigatorPlugin } from './definitions';

export class LocationSettingsNavigatorWeb extends WebPlugin implements LocationSettingsNavigatorPlugin {
  openLocationSettings(): Promise<any> {
    return Promise.resolve(undefined);
  }

  checkPermission(): Promise<any> {
    return Promise.resolve({ granted: true });
  }
}
