import Foundation

@objc public class LocationSettingsNavigator: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
