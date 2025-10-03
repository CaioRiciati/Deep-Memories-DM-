document.querySelector("#formCadastro1").addEventListener("submit", async (e) => {
  e.preventDefault();

  const email = document.querySelector("#email").value;
  const senha = document.querySelector("#senha").value;

  try {
    await login(email, senha);
    window.location.href = "CreateAccount.html";
  } catch (error) {
    alert("Login inválido.");
    console.error(error);
  }
});
