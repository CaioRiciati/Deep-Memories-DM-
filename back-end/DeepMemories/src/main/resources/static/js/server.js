  document.querySelector('form').addEventListener('submit', async function (event) {
    event.preventDefault(); // Impede envio padrão do form

    // Pegando valores dos campos
    const email = document.querySelector('#email').value;
    const nome = document.querySelector('#nome').value;
    const usuario = document.querySelector('#usuario').value;
    const senha = document.querySelector('#senha').value;

    // Validação básica
    if (!email || !nome || !usuario || !senha) {
      alert("Por favor, preencha todos os campos.");
      return;
    }

    const dados = { email, nome, usuario, senha };

    try {
      const response = await fetch('http://localhost:7070/api/usuario', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(dados),
      });

      if (!response.ok) {
        const erro = await response.json();
        throw erro;
      }

      const data = await response.json();
      console.log('Sucesso:', data);
      alert('Usuário criado com sucesso');

      // Redireciona após sucesso
      window.location.href = "criarSenha.html";

    } catch (error) {
      console.error('Erro:', error);
      alert(`Erro ao criar usuário: ${error.erro || error.message}`);
    }
  });