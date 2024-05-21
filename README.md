# Sistema de Gerenciamento de Faltas
Este é um sistema de gerenciamento de faltas para uma faculdade, desenvolvido em Java com uma interface gráfica em Swing. O projeto ainda está em desenvolvimento.

# Funcionalidades
 - Cadastro de Professores
 - Cadastro de Alunos
 - Cadastro de Matérias
 - Cadastro de Turmas
 - Registro de Presenças
 - Consulta de Presenças
# Pré-requisitos
 - Java 11 ou superior
 - Maven
# Configuração
Clone o repositório:

bash
```
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```
 - Atualize o caminho para o banco de dados SQLite em
'GetConnectionDatabase.java':

java:
```
private static final String URL = "jdbc:sqlite:/caminho/para/seu/banco/falta.db";
Compile e instale as dependências do projeto:
```

bash
```
mvn clean install
```
 - Execute o projeto:
bash
```
mvn exec:java -Dexec.mainClass="com.example.application.ui.MainApp"
```
# Uso
 - Ao iniciar o aplicativo, você verá uma interface com abas para cadastrar professores, alunos, matérias, turmas, registrar presenças e consultar presenças.
 - Navegue pelas abas para realizar as operações desejadas.

# Estrutura do Banco de Dados
As tabelas do banco de dados SQLite são estruturadas da seguinte maneira:

sql
```
CREATE TABLE Professor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL
);

CREATE TABLE Materia (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL
);

CREATE TABLE Turma (
    id INTEGER PRIMARY KEY AUTOINCREMENT
);

CREATE TABLE Materia_Turma (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_materia INTEGER,
    id_turma INTEGER,
    id_professor INTEGER,
    FOREIGN KEY (id_materia) REFERENCES Materia(id),
    FOREIGN KEY (id_turma) REFERENCES Turma(id),
    FOREIGN KEY (id_professor) REFERENCES Professor(id)
);

CREATE TABLE Aluno (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    id_turma INTEGER,
    FOREIGN KEY (id_turma) REFERENCES Turma(id)
);

CREATE TABLE Aula (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    conteudo TEXT,
    numero INTEGER,
    id_materia_turma INTEGER,
    FOREIGN KEY (id_materia_turma) REFERENCES Materia_Turma(id)
);

CREATE TABLE Presenca (
    id_aluno INTEGER,
    id_aula INTEGER,
    presente INTEGER,
    PRIMARY KEY (id_aluno, id_aula),
    FOREIGN KEY (id_aluno) REFERENCES Aluno(id),
    FOREIGN KEY (id_aula) REFERENCES Aula(id)
);
```
# Contato
 - Karim Galil Tamimi Alzeben - ktalzeben@gmail.com
 - Vinicius Nessler - vnessler266@gmail.com
