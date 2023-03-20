-keep class com.example.android_lib.HomeFragment {
    <init>();
    public static com.example.android_lib.HomeFragment newInstance(java.lang.String, java.lang.String);
    public void onCreate(android.os.Bundle);
    public android.view.View onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle);
    public static com.example.android_lib.HomeFragment$Companion Companion;
}
-keep class com.example.android_lib.HomeFragment$Companion {
    public com.example.android_lib.HomeFragment newInstance(java.lang.String, java.lang.String);
}
-keep class com.example.android_lib.HomeFragmentKt {
}
