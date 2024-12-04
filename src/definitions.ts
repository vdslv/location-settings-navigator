export interface LocationSettingsNavigatorPlugin {
  openLocationSettings(): Promise<void>;
  checkPermission(): Promise<PermissionStatus>;
}

export interface PermissionStatus {
  granted: boolean;
}
