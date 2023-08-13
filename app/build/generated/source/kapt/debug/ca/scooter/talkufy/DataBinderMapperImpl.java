package ca.scooter.talkufy;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import ca.scooter.talkufy.databinding.ReceivedAudioItemBindingImpl;
import ca.scooter.talkufy.databinding.SentAudioItemBindingImpl;
import ca.scooter.talkufy.databinding.SentAudioPlaceholderItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_RECEIVEDAUDIOITEM = 1;

  private static final int LAYOUT_SENTAUDIOITEM = 2;

  private static final int LAYOUT_SENTAUDIOPLACEHOLDERITEM = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(ca.scooter.talkufy.R.layout.received_audio_item, LAYOUT_RECEIVEDAUDIOITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ca.scooter.talkufy.R.layout.sent_audio_item, LAYOUT_SENTAUDIOITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ca.scooter.talkufy.R.layout.sent_audio_placeholder_item, LAYOUT_SENTAUDIOPLACEHOLDERITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_RECEIVEDAUDIOITEM: {
          if ("layout/received_audio_item_0".equals(tag)) {
            return new ReceivedAudioItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for received_audio_item is invalid. Received: " + tag);
        }
        case  LAYOUT_SENTAUDIOITEM: {
          if ("layout/sent_audio_item_0".equals(tag)) {
            return new SentAudioItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for sent_audio_item is invalid. Received: " + tag);
        }
        case  LAYOUT_SENTAUDIOPLACEHOLDERITEM: {
          if ("layout/sent_audio_placeholder_item_0".equals(tag)) {
            return new SentAudioPlaceholderItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for sent_audio_placeholder_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "message");
      sKeys.put(2, "position");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/received_audio_item_0", ca.scooter.talkufy.R.layout.received_audio_item);
      sKeys.put("layout/sent_audio_item_0", ca.scooter.talkufy.R.layout.sent_audio_item);
      sKeys.put("layout/sent_audio_placeholder_item_0", ca.scooter.talkufy.R.layout.sent_audio_placeholder_item);
    }
  }
}
