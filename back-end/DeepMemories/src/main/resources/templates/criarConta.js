document.getElementById('form-cadastro').addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o comportamento padrão de envio do formulário.

    // Coleta os valores dos campos de entrada no momento do envio.
    const email = document.getElementById("iemail").value;
    const usuario = document.getElementById("iusuario").value; // Corrigido para 'iusuario'
    const senha = document.getElementById("isenha").value;

    console.log(email);
    console.log(usuario);
    console.log(senha);

    const dados = { email, usuario, senha };

    fetch('http://localhost:8082/cadastroUsuario', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(dados),
    })
    .then(response => {
        if (!response.ok) {
            // Em caso de erro HTTP, extrai e rejeita o erro
            return response.json().then(err => Promise.reject(err));
        }
        return response.json();
    })
    .then(data => {
        console.log('Sucesso:', data);
        alert('Usuário criado com sucesso!');
        // Opcional: Redirecionar para outra página ou limpar o formulário
    })
    .catch(error => {
        console.error('Erro:', error);
        alert(`Erro ao criar usuário: ${error.erro || error.message}`);
    });
});