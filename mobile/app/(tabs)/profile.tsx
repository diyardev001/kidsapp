import { StyleSheet, Text, TouchableOpacity, View ,Image} from 'react-native'
import React from 'react'

const profile = () => {
  const user = {
    isAuthenticated: true,
    name: "Kevin Mayer",
    email: "Kevin_Mayer@gmail.com",
    phone: "+49 (173) 4354233",
    image: require('../../assets/images/profile.jpg'),
  }
//wenn nicht eingeloggt
  if (!user.isAuthenticated) {
    return (
      <View style={styles.centered}>
        <Text>Bitte logge dich ein, um dein Profil zu sehen</Text>
      </View>
    );
  }

  //wenn eingeloggt
  return (
    <View style={styles.container}>
      <Image source={user.image} style={styles.avatar} />
      <Text style={styles.name}>{user.name}</Text>
      <Text style={styles.info}>{user.email}</Text>
      <Text style={styles.info}>{user.phone}</Text>

      <TouchableOpacity style={styles.button}><Text style={styles.buttonText}>Favoriten</Text></TouchableOpacity>
      <TouchableOpacity style={styles.button}><Text style={styles.buttonText}>Angemeldete Aktivitäten</Text></TouchableOpacity>
      <TouchableOpacity style={styles.button}><Text style={styles.buttonText}>Besuchte Aktivitäten</Text></TouchableOpacity>
      <TouchableOpacity style={[styles.button, styles.settingsButton]}><Text style={styles.buttonText}>Einstellungen</Text></TouchableOpacity>
    </View>
  );
}

export default profile

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    paddingTop: 80,
    backgroundColor: '#fff',
  },
  centered: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  avatar: {
    width: 100,
    height: 100,
    borderRadius: 50,
    marginBottom: 20,
  },
  name: {
    fontSize: 22,
    fontWeight: 'bold',
    marginBottom: 8,
  },
  info: {
    fontSize: 16,
    color: 'gray',
    marginBottom: 6,
  },
  button: {
    width: '80%',
    backgroundColor: '#ff5a3c',
    padding: 14,
    borderRadius: 10,
    alignItems: 'center',
    marginTop: 10,
  },
  settingsButton: {
    backgroundColor: '#333',
  },
  buttonText: {
    color: 'white',
    fontWeight: '600',
  },
});