package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new ca.scooter.talkufy.DataBinderMapperImpl());
  }
}
