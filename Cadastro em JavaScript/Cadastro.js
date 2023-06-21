// função para pegar os valores dos campos do formulário e criar um objeto de cadastro
function criarCadastro() {
    const nome = document.querySelector('#name').value;
    const descricao = document.querySelector('#descricao').value;
    const valor = document.querySelector('#valor').value;
    const disponivel = document.querySelector('#disponivel').value;

    if (nome.length === 0 || descricao.length === 0 || valor.length === 0 || disponivel.length === 0) {
        return;
    } else {
        const cadastro = { nome, descricao, valor, disponivel };
        return cadastro;
    }
}

// função para adicionar o cadastro à lista de cadastros e salvar no localStorage
function adicionarCadastro() {
    const cadastrar = criarCadastro(); //{ nome, email, telefone, celular }
    if (!cadastrar) {
        alert("Por favor, preencher todos os dados");
        return;
    }
    //pegando a lista de contatos ja convertida
    const listaCadastros = carregarCadastros();
    //adiciono a lista o contato com push
    listaCadastros.push(cadastrar);
    // salva a lista de cadastros no localStorage convertendo com o stringify
    localStorage.setItem('listaCadastros', JSON.stringify(listaCadastros));
    // limpa os campos de input
    document.querySelector('#name').value = '';
    document.querySelector('#descricao').value = '';
    document.querySelector('#valor').value = '';
    document.querySelector('#disponivel').value = '';

};

function carregarCadastros() {
    // Carrega a lista de cadastros do localStorage
    const cadastrosJSON = localStorage.getItem('listaCadastros');
    // Se a lista de cadastros não existir no localStorage, retorna um array vazio
    //Converto a lista do localStorage em um objeto JS
    return JSON.parse(cadastrosJSON) || [];
}

// função para exibir a lista de cadastros na tabela
function exibirCadastros() {
    const tbody = document.querySelector('.resulExibir');
    // recupera a lista de cadastros do localStorage e converte de volta para um array de objetos
    const listaCadastros = carregarCadastros();
    // percorre a lista de cadastros e adiciona uma linha na tabela para cada cadastro
    listaCadastros.forEach(cadastro => {
        const tr = document.createElement('tr');
        const tdNome = document.createElement('td');
        const tdValor = document.createElement('td');
        tdNome.textContent = cadastro.nome;
        tdValor.textContent ="R$ " + cadastro.valor;
        tr.appendChild(tdNome);
        tr.appendChild(tdValor);
        tbody.appendChild(tr);
    });
}

function removerTr() {
    //vou buscar se exite a tag com id remover, caso não exita passo
    if (!document.querySelector('#remover')) {
        return;
    }
    //se existir eu retiro para adcionar o novo
    document.querySelector('#remover').remove();
}

const cadastrarBtn = document.querySelector('#cadastro');
if (cadastrarBtn) {
    cadastrarBtn.addEventListener('click', function () {
        adicionarCadastro()

    });
}

window.addEventListener('load', exibirCadastros)