// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "LocationSettingsNavigator",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "LocationSettingsNavigator",
            targets: ["LocationSettingsNavigatorPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "LocationSettingsNavigatorPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/LocationSettingsNavigatorPlugin"),
        .testTarget(
            name: "LocationSettingsNavigatorPluginTests",
            dependencies: ["LocationSettingsNavigatorPlugin"],
            path: "ios/Tests/LocationSettingsNavigatorPluginTests")
    ]
)