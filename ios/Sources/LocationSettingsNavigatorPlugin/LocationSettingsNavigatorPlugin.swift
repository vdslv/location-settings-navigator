import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(LocationSettingsNavigatorPlugin)
public class LocationSettingsNavigatorPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "LocationSettingsNavigatorPlugin"
    public let jsName = "LocationSettingsNavigator"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "echo", returnType: CAPPluginReturnPromise)
    ]
    private let implementation = LocationSettingsNavigator()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }
}
