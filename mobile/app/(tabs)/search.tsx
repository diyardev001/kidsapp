import React from 'react';
import { View, Text, FlatList, Image, StyleSheet, ImageSourcePropType } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';

// Beispiel-Daten für Aktivitäten
const ACTIVITIES_DATA = [
  {
    id: '1',
    title: 'Adventsgrabung',
    location: 'VK Stadium',
    date: '28.03 20:00',
    price: '5€',
    imageUrl: require('../../assets/images/Adventsgrabung.jpg'),
    status: null,
  },
  {
    id: '2',
    title: 'Illusions',
    location: 'Spielplatz an der Hörde',
    date: '07.03 14:00',
    price: 'Gratis',
    imageUrl: require('../../assets/images/Illusion.jpg'),
    status: 'Hat begonnen',
  },
  {
    id: '3',
    title: "Woman's Day",
    location: 'VK Stadium',
    date: '03.04 20:00',
    price: 'Gratis',
    imageUrl: require('../../assets/images/WomansDay.jpg'),
    status: null,
  },
  {
  id: '4',
  title: "Kulturrucksack Party",
  location: 'Jugendzentrum Herne',
  date: '26.03 14:00',
  price: 'Gratis',
  imageUrl: require('../../assets/images/Kulturrucksack_Party.jpg'),
  status: null,
  },
  {
    id: '5',
    title: 'Kinder-Flohmarkt',
    location: 'Marktplatz Innenstadt',
    date: '15.06 10:00',
    price: 'Standgebühr 5€',
    imageUrl: require('../../assets/images/Flohmarkt.jpg'),
    status: 'Anmeldung\nerforderlich',
  },
  {
    id: '6',
    title: 'Waldabenteuer für Kids',
    location: 'Stadtwald Süd',
    date: '22.06 15:00',
    price: '3€',
    imageUrl: require('../../assets/images/Waldabenteuer.jpg'),
    status: null,
  },
  {
    id: '7',
    title: 'Märchenstunde in der Bibliothek',
    location: 'Stadtbibliothek Zentrum',
    date: '29.06 11:00',
    price: 'Gratis',
    imageUrl: require('../../assets/images/Märchenstunde.jpg'),
    status: 'Fast\nausgebucht',
  },
  {
    id: '8',
    title: 'Sportfest der Grundschulen',
    location: 'Sportanlage West',
    date: '06.07 09:00',
    price: 'Gratis',
    imageUrl: require('../../assets/images/Sportfest.jpg'),
    status: null,
  },
  {
    id: '9',
    title: 'Kreativwerkstatt: Töpfern',
    location: 'Kunstschule "Farbtupfer"',
    date: '13.07 14:30',
    price: '10€ Materialkosten',
    imageUrl: require('../../assets/images/Töpfern.jpg'),
    status: null,
  },
];

type ActivityItemProps = {
  title: string;
  location: string;
  date: string;
  price: string;
  imageUrl: ImageSourcePropType;
  status?: string | null;
};

const ActivityItem: React.FC<ActivityItemProps> = ({ title, location, date, price, imageUrl, status }) => (
  <View style={styles.itemContainer}>
    <Image source={imageUrl} style={styles.image} />
    <View style={styles.infoContainer}>
      <Text style={styles.title}>{title}</Text>
      <Text style={styles.location}>{location}</Text>
      <Text style={styles.date}>{date}</Text>
      <Text style={styles.price}>{price}</Text>
    </View>
    {status && (
      <View style={styles.statusBadge}>
        <Text style={styles.statusText}>{status}</Text>
      </View>
    )}
  </View>
);

export default function SearchScreen() {
  return (
    <SafeAreaView style={styles.container}>
      <FlatList
        data={ACTIVITIES_DATA}
        renderItem={({ item }) => <ActivityItem {...item} />}
        keyExtractor={item => item.id}
        contentContainerStyle={styles.listContentContainer}
      />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
  listContentContainer: {
    paddingHorizontal: 16,
    paddingTop: 20,
    paddingBottom: 120,
  },
  itemContainer: {
    flexDirection: 'row',
    backgroundColor: '#f9f9f9',
    borderRadius: 8,
    padding: 12,
    marginBottom: 16,
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.1,
    shadowRadius: 3.84,
    elevation: 5,
    position: 'relative',
  },
  image: {
    width: 80,
    height: 80,
    borderRadius: 8,
    marginRight: 12,
  },
  infoContainer: {
    flex: 1,
    justifyContent: 'center',
    marginRight: 70,
  },
  title: {
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 4,
  },
  location: {
    fontSize: 14,
    color: '#555',
    marginBottom: 2,
  },
  date: {
    fontSize: 14,
    color: '#555',
    marginBottom: 2,
  },
  price: {
    fontSize: 14,
    color: 'green',
    fontWeight: 'bold',
  },
  statusBadge: {
    position: 'absolute',
    top: 8,
    right: 8,
    backgroundColor: 'red',
    paddingHorizontal: 8,
    paddingVertical: 4,
    borderRadius: 4,
  },
  statusText: {
    color: '#fff',
    fontSize: 10,
    fontWeight: 'bold',
  },
});