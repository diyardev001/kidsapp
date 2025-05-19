import React, { useState, useEffect } from "react";
import {
  StyleSheet,
  View,
  Dimensions,
  TouchableOpacity,
  Image,
} from "react-native";
import MapView, { Marker } from "react-native-maps";
import * as Location from "expo-location";

const InteractiveMap = () => {
  const [region, setRegion] = useState({
    latitude: 51.549999,
    longitude: 7.216667,
    latitudeDelta: 0.05,
    longitudeDelta: 0.05,
  });
  const [location, setLocation] = useState<Location.LocationObject | null>(
    null
  );

  useEffect(() => {
    (async () => {
      let { status } = await Location.requestForegroundPermissionsAsync();
      if (status !== "granted") {
        console.log("Permission to access location was denied");
        return;
      }

      let userLocation = await Location.getCurrentPositionAsync({});
      setLocation(userLocation);
      setRegion({
        latitude: userLocation.coords.latitude,
        longitude: userLocation.coords.longitude,
        latitudeDelta: 0.05,
        longitudeDelta: 0.05,
      });
    })();
  }, []);

  const zoomIn = () => {
    setRegion((prevRegion) => ({
      ...prevRegion,
      latitudeDelta: prevRegion.latitudeDelta / 2,
      longitudeDelta: prevRegion.longitudeDelta / 2,
    }));
  };

  const zoomOut = () => {
    setRegion((prevRegion) => ({
      ...prevRegion,
      latitudeDelta: prevRegion.latitudeDelta * 2,
      longitudeDelta: prevRegion.longitudeDelta * 2,
    }));
  };

  return (
    <View style={styles.container}>
      <MapView
        style={styles.map}
        region={region}
        onRegionChangeComplete={(newRegion) => setRegion(newRegion)}
        showsUserLocation={false}
      >
        {location && (
          <Marker
            coordinate={{
              latitude: location.coords.latitude,
              longitude: location.coords.longitude,
            }}
          >
            <View style={styles.userLocationMarker} />
          </Marker>
        )}
      </MapView>

      <TouchableOpacity style={[styles.button, styles.zoomIn]} onPress={zoomIn}>
        <Image
          source={require("@/assets/images/icons/activityMap/zoomin.png")}
          style={styles.icon}
        />
      </TouchableOpacity>

      <TouchableOpacity
        style={[styles.button, styles.zoomOut]}
        onPress={zoomOut}
      >
        <Image
          source={require("@/assets/images/icons/activityMap/zoomout.png")}
          style={styles.icon}
        />
      </TouchableOpacity>

      <TouchableOpacity
        style={[
          styles.button,
          styles.myLocation,
          { backgroundColor: "#fd573b", marginTop: 100 },
        ]}
        onPress={() => {
          if (location) {
            setRegion({
              latitude: location.coords.latitude,
              longitude: location.coords.longitude,
              latitudeDelta: 0.05,
              longitudeDelta: 0.05,
            });
          }
        }}
      >
        <Image
          source={require("@/assets/images/icons/activityMap/myLocation.png")}
          style={styles.icon}
        />
      </TouchableOpacity>
    </View>
  );
};

export default InteractiveMap;

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  map: {
    width: Dimensions.get("window").width,
    height: Dimensions.get("window").height,
  },
  button: {
    position: "absolute",
    backgroundColor: "white",
    borderRadius: 10,
    padding: 15,
    elevation: 5,
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.25,
    shadowRadius: 3.84,
    zIndex: 10,
  },
  zoomIn: {
    top: Dimensions.get("window").height * 0.4,
    right: 20,
  },
  zoomOut: {
    top: Dimensions.get("window").height * 0.5,
    right: 20,
  },
  myLocation: {
    top: Dimensions.get("window").height * 0.6,
    right: 20,
  },
  icon: {
    width: 30,
    height: 30,
  },
  userLocationMarker: {
    width: 30,
    height: 30,
    borderRadius: 50,
    backgroundColor: "#fd573b",
    borderWidth: 5,
    borderColor: "white",
  },
});
