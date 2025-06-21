const form = document.getElementById("form-cadastro");
const mensagem = document.getElementById("mensagem");

form.addEventListener("submit", async function(event) {
  event.preventDefault();

  const nome = document.getElementById("nome").value.trim();
  const usename = document.getElementById("username").value.trim();
  const email = document.getElementById("email").value.trim();
  const senha = document.getElementById("senha").value.trim();

  if (!nome || !username ||!email || !senha) {
    mensagem.textContent = "Preencha todos os campos.";
    mensagem.style.color = "red";
    return;
  }

  // Parte para integrar com o back-end
  try {
    const response = await fetch("http://localhost:8080/api/usuarios", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ nome, username, email, senha })
    });

    if (response.ok) {
      mensagem.textContent = "Usuário cadastrado com sucesso!";
      mensagem.style.color = "green";
      form.reset();
    } else {
      mensagem.textContent = "Erro ao cadastrar. Verifique os dados.";
      mensagem.style.color = "red";
    }
  } catch (error) {
    console.error("Erro na requisição:", error);
    mensagem.textContent = "Erro ao conectar com o servidor.";
    mensagem.style.color = "red";
  }
});
