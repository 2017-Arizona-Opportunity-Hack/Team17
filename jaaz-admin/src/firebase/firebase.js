import Firebase from 'firebase'
import 'firebase/firestore';

let config = {
  apiKey: "AIzaSyDgrTSFXKVJSLIWgwLJlWbTXftjb-89fr8",
  authDomain: "ja-arizona-26ebd.firebaseapp.com",
  databaseURL: "https://ja-arizona-26ebd.firebaseio.com",
  projectId: "ja-arizona-26ebd",
  storageBucket: "ja-arizona-26ebd.appspot.com",
  messagingSenderId: "209276924145"
};

const app = Firebase.initializeApp(config);
const firestore = Firebase.firestore();

export const usersCollection = firestore.collection('users');
export const positionsCollection = firestore.collection('positions');