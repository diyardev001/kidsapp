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

  //wenn nt eingeloggt 
  if (!user.isAuthenticated) {
    return (
      <View>
        <Text>Bitte logge dich ein, um dein Profil zu sehen</Text>
      </View>
    );
  }

  //wenn eingeloggt
  return (
    <View>
      <Image source={user.image} />
      <Text>{user.name}</Text>
      <Text>{user.email}</Text>
      <Text>{user.phone}</Text>

      <TouchableOpacity>
        <Text>Favoriten</Text>
      </TouchableOpacity>
      <TouchableOpacity>
        <Text>Angemeldete Aktivitäten</Text>
      </TouchableOpacity>
      <TouchableOpacity>
        <Text>Besuchte Aktivitäten</Text>
      </TouchableOpacity>
      <TouchableOpacity>
        <Text>Einstellungen</Text>
      </TouchableOpacity>
    </View>
  );
}

export default profile

const styles = StyleSheet.create({})