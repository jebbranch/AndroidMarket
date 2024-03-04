package rv.clockworks.androidmarket.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class KeepAliveService extends Service {
    public KeepAliveService() {
        //TODO:保活服务
    }

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
}