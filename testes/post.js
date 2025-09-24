function fazPost(url, body) {
    console.log("Body=", body)
    let request = new XMLHttpRequest()
    request.open("POST", url, true)
    request.setRequestHeader("Content-type", "application/json")
    request.send(JSON.stringify(body))

    request.onload = function() {
        console.log(this.responseText)
    }

    return request.responseText
}


function cadastraUsuario() {
    preventDefault()
    let url = "http://localhost8082/novoUsuario"
    const iemail = document.getElementById("iemail").value;
    const iusuario = document.getElementById("iusuario").value; 

    console.log(iusuario)
    console.log(iemail)

    body = {
        "iusuario": iusuario,
        "iemail": iemail
    }

    fazPost(url, body)
}