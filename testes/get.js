function fazGet(url) {
    let request = new XMLHttpRequest()
    request.open("GET", url, false)
    request.send()
    return request.responseText
}

function criarLinha(usuario) {
    console.log(usuario)
    linha = document.createElement("tr");
    tdId = document.createElement("td");
    tdNome = document.createElement("td");
    tdId.innerHTML = usuario.id
    tdNome.innerHTML = usuario.name

    linha.appendChild(tdId);
    linha.appendChild(tdNome);

    return linha;
}

function main() {
    data = (fazGet("http://localhost8082/novoUsuario"));
    usuario = JSON.parse(data);
    let input = document.getElementById("formulario")
    usuarios.array.forEach(element => {
        let linha = criarLinha(element);
        input.appendChild(linha);
    });
}

main()