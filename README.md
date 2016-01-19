# Getting child fragment on Android API 19 and older

This is a demo Android app showing an issue with getting a fragment from another fragment in Android API version 19 and older using the following code.


```Java
Fragment fragment = getChildFragmentManager().findFragmentById(R.id.child);
```

The code above works only from API version 21 and newer. On API version 19 and older it returns null.

## The workaround

In order to get a child fragment on Android API 19 and older one can use the following code instead.


```Java
fragment = getActivity().getFragmentManager().findFragmentById(R.id.child);
```

<img src="https://raw.githubusercontent.com/evgenyneu/DemoChildFragment/master/graphics/android_getChildFragmentManager_api_19.png" alt="Android run getChildFragmentManager on API 19" width="300" >
