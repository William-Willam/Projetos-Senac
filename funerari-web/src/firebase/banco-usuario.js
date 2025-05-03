import {
    addDoc,
    collection,
    deleteDoc,
    doc,
    getDoc,
    getDocs,
    query,
    updateDoc,
    where,
  } from "firebase/firestore";

  import { db } from "./config";
  import toast from "react-hot-toast";

  //Banco de Dados Usuários
  const usuarioCol = collection(db, "usuarioComum");

  //C.R.U.D(usuario)

  // Criar usuario
  export async function adicionarUsuario({uid, nome, cpf, email}) {
    try {
        await addDoc(usuarioCol,{uid,nome, cpf, email, criadoEm: new Date()});
        toast.success("Dados do usuário salvos com sucesso!");
    } catch (error) {
        console.error("Erro ao salvar dados do usuário:", error);
        toast.error("Erro ao salvar dados do usuário.");
    }
  }
