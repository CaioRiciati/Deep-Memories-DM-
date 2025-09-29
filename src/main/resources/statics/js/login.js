const API_BASE_URL = "http://localhost:8082";

document.querySelector("#formCadastro1").addEventListener("submit", async (e) => {
  e.preventDefault();

  const email = document.querySelector("email").value;
  const senha = document.querySelector("senha").value;

  try {
    const data = await API_BASE_URL.login({ email, senha });
    localStorage.setItem("token", data.token);
    window.location.href = "CreateAccount.html";
  } catch (error) {
    alert("Login inválido.");
  }
});
