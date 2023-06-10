package allgemein;

import java.util.*;

import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;

public class BluetoothDeviceDiscovery {

    public static void main(String[] args) {

        try {
            // DiscoveryAgent erstellen
            LocalDevice localDevice = LocalDevice.getLocalDevice();
            DiscoveryAgent agent = localDevice.getDiscoveryAgent();

            // Listener für Gerätediscovery registrieren
            DeviceDiscoveryListener listener = new DeviceDiscoveryListener();
            agent.startInquiry(DiscoveryAgent.GIAC, listener);

            // Warten, bis die Discovery abgeschlossen ist
            Thread.sleep(5000);

            // Gefundene Geräte anzeigen
            List<RemoteDevice> devices = listener.getDiscoveredDevices();
            for (RemoteDevice device : devices) {
                System.out.println("Gerät gefunden: " + device.getBluetoothAddress() + " - " + device.getFriendlyName(false));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}