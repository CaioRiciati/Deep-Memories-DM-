async function criarConta() {
    const email = document.getElementById("email").value;
    const nome = document.getElementById("nome").value;
    const usuario = document.getElementById("usuario").value;
    const senha = document.getElementById("senha").value;

    console.log(email, nome, usuario, senha); // Para teste

    if (!email || !nome || !usuario || !senha) {
      alert("Por favor, preencha todos os campos.");
      return false;
    }

    // Redireciona
    window.location.href = "criarSenha.html";
    return false; // Impede o envio real do formulário
  }
