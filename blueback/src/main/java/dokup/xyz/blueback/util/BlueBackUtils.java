package dokup.xyz.blueback.util;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;

/**
 * Created by e10dokup on 2016/06/06
 **/
public class BlueBackUtils {
    private static final String TAG = BlueBackUtils.class.getSimpleName();
    private final BlueBackUtils self = this;

    /**
     * Checking device support for advertisement.
     * @param context
     * @return boolean
     */
    public static boolean canAdvertise(Context context) {
        BluetoothManager manager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter adapter = manager.getAdapter();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP && adapter != null) {
            boolean multipleAdvertisementSupport = adapter.isMultipleAdvertisementSupported();
            boolean offloadedFilteringSupport = adapter.isOffloadedFilteringSupported();
            boolean offloadedScanBatchingSupported = adapter.isOffloadedScanBatchingSupported();

            return multipleAdvertisementSupport && offloadedFilteringSupport && offloadedScanBatchingSupported;
        } else {
            return false;
        }
    }

    /**
     * Checking device support for scanning.
     * @param context
     * @return boolean
     */
    public static boolean canScan(Context context) {
        BluetoothManager manager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter adapter = manager.getAdapter();
        return android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2 && adapter != null;
    }
}