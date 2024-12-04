# location-settings-navigator

Navigate user directly to location permission settings of an app.

## Install

```bash
npm install location-settings-navigator
npx cap sync
```

## API

<docgen-index>

* [`openLocationSettings()`](#openlocationsettings)
* [`checkPermission()`](#checkpermission)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### openLocationSettings()

```typescript
openLocationSettings() => Promise<void>
```

--------------------


### checkPermission()

```typescript
checkPermission() => Promise<PermissionStatus>
```

**Returns:** <code>Promise&lt;<a href="#permissionstatus">PermissionStatus</a>&gt;</code>

--------------------


### Interfaces


#### PermissionStatus

| Prop          | Type                 |
| ------------- | -------------------- |
| **`granted`** | <code>boolean</code> |

</docgen-api>
