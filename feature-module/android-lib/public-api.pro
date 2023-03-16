-keep class com.example.android_lib.BlankFragment {
    <init>();
    public static com.example.android_lib.BlankFragment newInstance(java.lang.String, java.lang.String);
    public void onCreate(android.os.Bundle);
    public android.view.View onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle);
    public static com.example.android_lib.BlankFragment$Companion Companion;
}
-keep class com.example.android_lib.BlankFragment$Companion {
    public com.example.android_lib.BlankFragment newInstance(java.lang.String, java.lang.String);
}
-keep class com.example.android_lib.BlankFragmentKt {
}
