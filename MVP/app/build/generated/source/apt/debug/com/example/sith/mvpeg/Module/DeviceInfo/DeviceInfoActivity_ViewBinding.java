// Generated code from Butter Knife. Do not modify!
package com.example.sith.mvpeg.Module.DeviceInfo;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.sith.mvpeg.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DeviceInfoActivity_ViewBinding implements Unbinder {
  private DeviceInfoActivity target;

  private View view7f080044;

  @UiThread
  public DeviceInfoActivity_ViewBinding(DeviceInfoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DeviceInfoActivity_ViewBinding(final DeviceInfoActivity target, View source) {
    this.target = target;

    View view;
    target.manufacturer = Utils.findRequiredViewAsType(source, R.id.device_manufacturer_details, "field 'manufacturer'", EditText.class);
    target.modelName = Utils.findRequiredViewAsType(source, R.id.device_model_details, "field 'modelName'", EditText.class);
    target.osName = Utils.findRequiredViewAsType(source, R.id.device_os_details, "field 'osName'", EditText.class);
    target.imeiList = Utils.findRequiredViewAsType(source, R.id.device_imeis_details, "field 'imeiList'", EditText.class);
    view = Utils.findRequiredView(source, R.id.device_param_button, "field 'paramBut' and method 'onClick'");
    target.paramBut = Utils.castView(view, R.id.device_param_button, "field 'paramBut'", Button.class);
    view7f080044 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DeviceInfoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.manufacturer = null;
    target.modelName = null;
    target.osName = null;
    target.imeiList = null;
    target.paramBut = null;

    view7f080044.setOnClickListener(null);
    view7f080044 = null;
  }
}
