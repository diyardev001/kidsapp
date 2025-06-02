import { StyleSheet, Text, View } from 'react-native'
import React from 'react'

const profile = () => {
  const user = {
    isAuthenticated: true, 
    name: "Kevin Mayer",
    email: "Kevin_Mayer@gmail.com",
    phone: "+49 (179) 4354233",
    image: require('../../assets/images/profile.jpg'),
  };
  return (
    <View style={{ flex: 1, alignItems: "center", justifyContent: "center" }}>
      <Text>profile</Text>
    </View>
  )
}

export default profile

const styles = StyleSheet.create({})