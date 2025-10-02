import { apiGet } from "./api.js";

async function carregarUsuarios() {
  try {
    const usuarios = await apiGet("/usuarios");
    console.log("Lista de usuários:", usuarios);
  } catch (error) {
    console.error(error);
  }
}

carregarUsuarios();
