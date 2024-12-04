export interface LocationSettingsNavigatorPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
