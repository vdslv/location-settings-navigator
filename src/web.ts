import { WebPlugin } from '@capacitor/core';

import type { LocationSettingsNavigatorPlugin } from './definitions';

export class LocationSettingsNavigatorWeb extends WebPlugin implements LocationSettingsNavigatorPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
