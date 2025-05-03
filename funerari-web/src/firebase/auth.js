import {
  sendEmailVerification,
  createUserWithEmailAndPassword,
  GoogleAuthProvider,
  signInWithEmailAndPassword,
  signInWithPopup,
  signOut,
  updateProfile,
  GithubAuthProvider,
  FacebookAuthProvider,
  TwitterAuthProvider,
  sendPasswordResetEmail,
} from "firebase/auth";

import { auth } from "./config";
import toast from "react-hot-toast";

//Dados para implementar no FireStore Database
export async function cadastrarUsuario(nome, email, senha) {
  try {
    const { user } = await createUserWithEmailAndPassword(auth, email, senha);
    await updateProfile(user, { displayName: nome });
    await sendEmailVerification(user);
    toast.success(
      `Usuário ${nome} cadastrado com sucesso. Verifique seu email.`
    );

    return user;
  } catch (error) {
    console.error("Erro ao cadastrar usuário:", error);
    toast.error(error.message);
    throw error;
  }
}

// Acessar o login
export async function loginUsuario(email, senha) {
  try {
    await signInWithEmailAndPassword(auth, email, senha);
  } catch (error) {
    toast.error(error.message);
    throw error;
  }
}

// Sair do login
export async function logout() {
  await signOut(auth);
}
