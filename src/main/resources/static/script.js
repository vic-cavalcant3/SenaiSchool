document.addEventListener('DOMContentLoaded', () => {
  const tbody = document.getElementById('aluno-tbody');

  // Carregar alunos
  function carregarAlunos() {
    fetch('http://localhost:8080/alunos')
      .then(response => response.json())
      .then(data => {
        tbody.innerHTML = '';
        data.forEach(aluno => {
          const tr = document.createElement('tr');
          tr.innerHTML = `
            <td>${aluno.nome}</td>
            <td>${aluno.email}</td>
            <td>${aluno.telefone || '-'}</td>
            <td>
              <button class="btn btn-sm btn-danger" onclick="removerAluno(${aluno.id})">
                <i class="fas fa-trash"></i>
              </button>
            </td>
          `;
          tbody.appendChild(tr);
        });
      })
      .catch(error => {
        console.error('Erro ao carregar alunos:', error);
        alert('Erro ao carregar lista de alunos');
      });
  }

  // Carregar alunos ao iniciar
  carregarAlunos();
});

// Função para remover aluno
function removerAluno(id) {
  if (confirm('Tem certeza que deseja remover este aluno?')) {
    fetch(`http://localhost:8080/alunos/${id}`, {
      method: 'DELETE'
    })
    .then(() => {
      alert('Aluno removido com sucesso!');
      document.getElementById('aluno-tbody').innerHTML = '';
      document.dispatchEvent(new Event('DOMContentLoaded'));
    })
    .catch(error => {
      console.error('Erro ao remover aluno:', error);
      alert('Erro ao remover aluno');
    });
  }
}