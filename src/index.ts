import { registerPlugin } from '@capacitor/core';

import type { LocationSettingsNavigatorPlugin } from './definitions';

const LocationSettingsNavigator = registerPlugin<LocationSettingsNavigatorPlugin>('LocationSettingsNavigator', {
  web: () => import('./web').then((m) => new m.LocationSettingsNavigatorWeb()),
});

export * from './definitions';
export { LocationSettingsNavigator };
