const email = document.querySelector("#iemailC").value;
const usuario = document.querySelector("#iusuarioC").value;
const dados = {email, usuario};

fetch("http://localhost:8080/usuarios", {
    method: "POST",
    headers: {
        "ContentType": "application/json"
    },
    body: JSON.stringify(dados)
})
    .then(res => res.json())
    .then(data => {
        console.log("Resposta:", data)
    })
    .catch(err => {
        console.error("Erro na conexão:", err);
    })