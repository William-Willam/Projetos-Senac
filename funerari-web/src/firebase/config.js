// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getAuth } from "firebase/auth";
import { getFirestore } from "firebase/firestore"; 
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyBY8HO2IX-2AGe8hJ_FIXoWoFEDlj9YSC8",
  authDomain: "funerariasenac.firebaseapp.com",
  projectId: "funerariasenac",
  storageBucket: "funerariasenac.firebasestorage.app",
  messagingSenderId: "5925111195",
  appId: "1:5925111195:web:2f5fdde0619506806e0d3e",
  measurementId: "G-3KE1XHSZTX"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

// exporta os serviços 
export const auth = getAuth(app);
export const db = getFirestore(app);