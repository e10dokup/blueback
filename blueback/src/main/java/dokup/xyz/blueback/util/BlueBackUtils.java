package dokup.xyz.blueback.util;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;

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
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            boolean multipleAdvertisementSupport = adapter.isMultipleAdvertisementSupported();
            boolean offloadedFilteringSupport = adapter.isOffloadedFilteringSupported();
            boolean offloadedScanBatchingSupported = adapter.isOffloadedScanBatchingSupported();

            return multipleAdvertisementSupport && offloadedFilteringSupport && offloadedScanBatchingSupported;
        } else {
            return false;
        }
    }
}