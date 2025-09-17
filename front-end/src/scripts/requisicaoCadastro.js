document.getElementById('form-cadastro').addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.querySelector('#iemail').value;
    const usuario = document.querySelector('#iusuario').value;
    const senha = document.querySelector('#isenha').value;

    const dados = {email, usuario, senha};

    fetch('http://localhost:7070/api/usuario', {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(dados),
    })
    .then(response => {
        if (!response.ok) {
            return response.json().then(err => Promise.reject(err));
        }
        return response.json();
    })
    .then(data => {
        console.log('Sucesso:', data);
        alert('Usuário criado com sucesso');
    })
    .catch(error => {
        console.error('Erro:', error);
        alert(`Erro ao criar usuário: ${error.erro || error.message}`);
    });
});