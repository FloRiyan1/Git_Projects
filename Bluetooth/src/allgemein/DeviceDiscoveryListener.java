package allgemein;

import java.util.*;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

public class DeviceDiscoveryListener implements DiscoveryListener{
	 
	private List<RemoteDevice> discoveredDevices = new ArrayList<>();

	@Override
    public void deviceDiscovered(RemoteDevice device, DeviceClass deviceClass) {
        discoveredDevices.add(device);
    }
	
    public void inquiryCompleted(int discType) {
        synchronized (this) {
            this.notify();
        }
    }

	public void serviceSearchCompleted(int transID, int respCode) {
	}

	public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
	}

	public List<RemoteDevice> getDiscoveredDevices() {
		return discoveredDevices;
	}
}