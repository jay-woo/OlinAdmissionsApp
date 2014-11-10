package grimwootier.com.olinadmissions;

import android.app.Fragment;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ToggleButton;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;


public class OlinMap extends Fragment {

    protected boolean informative_mode = false;
    protected Marker ac_marker_info;

    public OlinMap() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_olin_map, container, false);
        return rootView;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {

        final GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        UiSettings map_settings = map.getUiSettings();
        map_settings.setZoomControlsEnabled(false);
        map.setMyLocationEnabled(true);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        LatLng olinCollege = new LatLng(42.292967, -71.263269);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(olinCollege) // Sets the center of the map to Mountain View
                .zoom(18) // Sets the zoom
                .bearing(310) // Sets the orientation of the camera to east
                .build(); // Creates a CameraPosition from the builder
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        LatLng academicCenter = new LatLng(42.293695, -71.264347);
        LatLng milasHall = new LatLng(42.292779, -71.264073);
        LatLng campusCenter = new LatLng(42.293541, -71.263395);
        LatLng westHall = new LatLng(42.293051, -71.262909);
        LatLng eastHall = new LatLng(42.292618, -71.262196);
        final MarkerOptions ac_marker = new MarkerOptions()
                .title("Academic Center")
                .snippet("Here's where students take classes")
                .position(academicCenter);
        MarkerOptions mh_marker = new MarkerOptions()
                .title("Milas Hall")
                .snippet("Here's where the library is")
                .position(milasHall);
        MarkerOptions cc_marker = new MarkerOptions()
                .title("Campus Center")
                .snippet("Here's the dining hall")
                .position(campusCenter);
        MarkerOptions wh_marker = new MarkerOptions()
                .title("West Hall")
                .snippet("Dormitories for freshmen and sophomores")
                .position(westHall);
        MarkerOptions eh_marker = new MarkerOptions()
                .title("East Hall")
                .snippet("Dormitories for juniors and seniors")
                .position(eastHall);
        map.addMarker(ac_marker);
        map.addMarker(mh_marker);
        map.addMarker(cc_marker);
        map.addMarker(wh_marker);
        map.addMarker(eh_marker);
        final LatLng ac_corner_NW = new LatLng(42.294006, -71.264993);
     // final LatLng ac_corner_SE = new LatLng(42.293288, -71.263794);
        final LatLng ac_corner_SE = new LatLng(42.292527, -71.261685);
        final LatLng ac_center = new LatLng(42.293552, -71.264463);
        final MarkerOptions ac_markeroptions = new MarkerOptions()
                .title("Check out what happens in the AC!")
                .position(ac_center)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
        final View story_view = this.getActivity().findViewById(R.id.story_button);
        map.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                Location currentLocation = map.getMyLocation();
                if (currentLocation != null) {
                    double lat = currentLocation.getLatitude();
                    double lon = currentLocation.getLongitude();
                    Log.i(Double.toString(lat), Double.toString(lon));
                    if (!informative_mode) {
                        if (lat < ac_corner_NW.latitude && lat > ac_corner_SE.latitude) {
                            if (lon > ac_corner_NW.longitude && lon < ac_corner_SE.longitude) {
                                story_view.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                }
                else {
                    story_view.setVisibility(View.GONE);
                }
            }
        });
        story_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .add(R.id.olin_map, new RoomStory())
                        .commit();
            }
        });
        final ToggleButton informativeMode = (ToggleButton) this.getActivity().findViewById(R.id.toggleButton);
        informativeMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleInformative();
                if (informative_mode) {
                    ac_marker_info = map.addMarker(ac_markeroptions);
                    story_view.setVisibility(View.GONE);
                }
                else {
                    ac_marker_info.remove();
                }
            }
        });
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.equals(ac_marker_info)) {
                    getFragmentManager().beginTransaction()
                            .add(R.id.olin_map, new RoomStory())
                            .commit();
                }
                return false;
            }
        });
    }
    private void toggleInformative() {
        informative_mode = !informative_mode;
    }
}








