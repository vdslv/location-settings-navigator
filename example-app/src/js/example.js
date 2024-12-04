import { LocationSettingsNavigator } from 'location-settings-navigator';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    LocationSettingsNavigator.echo({ value: inputValue })
}
