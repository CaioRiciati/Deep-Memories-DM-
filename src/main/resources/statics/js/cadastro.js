const API_BASE_URL = "http://localhost:8082";

document.querySelector("#formCadastro").addEventListener("submit", async (e) => {
  e.preventDefault();

  const nome = document.getElementById("nome").value;
  const email = document.getElementById("email").value;
  const senha = document.getElementById("senha").value;
  const usuario = document.getElementById("usuario").value;

  try {
    await api.cadastrar({ nome, email, senha, usuario });
    alert("Cadastro realizado com sucesso!");
    window.location.href = "CreateAccount.html";
  } catch (error) {
    alert("Erro ao cadastrar usuário.");
  }
});