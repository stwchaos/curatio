
<h1 align="center"> Projeto Integrador - Curatio  </h1>


---
### Progresso do projeto
▓▓▓▓▓▓▓▓▓▓░ 95%



---

## Introdução
O Projeto Integrador que estamos desenvolvendo na linguagem Java tem como objetivo criar um software específico para hospitais, visando aprimorar o controle de pacientes e consultas pelos profissionais da área de saúde. Esse projeto está sendo desenvolvido para a disciplina de Projeto Integrador no Instituto Federal de Santa Catarina.

O software que estamos criando oferece diversas funcionalidades para facilitar o gerenciamento de pacientes e consultas, tais como:

 - Cadastro de pacientes: O usuário poderá cadastrar novos pacientes, incluindo informações como nome, idade, sexo, nome social(se houver), CEP, e-mail e telefone.

 - Pesquisa de pacientes: O software permite a pesquisa de pacientes cadastrados, facilitando a busca por informações específicas.

 - Alteração de informações já cadastradas: Caso haja necessidade de atualização de alguma informação do paciente, o usuário poderá alterá-la facilmente.

 - Acesso às informações dos pacientes: Todas as informações dos pacientes ficam disponíveis para acesso, permitindo que os profissionais de saúde possam visualizar o histórico de consultas, tratamentos e exames realizados.

 - Cancelamento de consultas: É possível cancelar consultas marcadas, evitando a perda de tempo dos profissionais de saúde e dos pacientes.

 - Agendamento de consultas: O software permite o agendamento de consultas, otimizando o tempo dos profissionais de saúde e dos pacientes.

 - Visualização do histórico de consultas: O software possibilita a visualização do histórico de consultas realizadas pelo paciente, tornando mais fácil o acompanhamento de seu estado de saúde.

 - Visualização de consultas pendentes: Todas as consultas pendentes ficam disponíveis para visualização, facilitando o gerenciamento das consultas marcadas.

O nosso software é uma solução completa para a gestão de pacientes e consultas em hospitais, oferecendo uma interface fácil de usar e eficiente para os profissionais de saúde.


## :wrench: TECNOLOGIAS UTILIZADAS

- [Eclipse IDE 2022-06](https://www.eclipse.org/downloads/);
- [WindowBuilder](https://www.eclipse.org/windowbuilder/);
- Swing;
- Java(TM) SE Development Kit 18.0.2; 
- Bibliotecas/.jar externos: Miglayout-Core-4.2, Miglayout-Swing-4.2, Apache Maven, Junit-jupiter-api-5.9.1, Junit-platform-commons-1.9.1, Jcalendar-1.4, Apiguardian-api-1.1.2, mysql-connector-java-8.0.30, Opentst4j-1.2.0, Protobuf-java-3.19.4;

## :busts_in_silhouette: Equipe de desenvolvimento do projeto
- [@Misomania]
- [@stwchaos]
- [@BernardoDB1]
- [@Gabrielrb68]

## Paleta de cores utilizada no projeto

<table>
  <tbody>
    <tr>
      <td style="background-color:#ffffff; color:#000000">#ffffff</td>
      <td style="background-color:#eeeeee; color:#000000">#eeeeee</td>
      <td style="background-color:#408080; color:#ffffff">#408080</td>
      <td style="background-color:#015152; color:#ffffff">#015152</td>
      <td style="background-color:#000000; color:#ffffff">#000000</td>
    </tr>
    <tr>
      <td style="background-color:#7ed957">#7ed957</td>
      <td style="background-color:#99e17a">#99e17a</td>
      <td style="background-color:#1d8e4e; color:#ffffff">#1d8e4e</td>
      <td style="background-color:#7fbf9b">#7fbf9b</td>
      <td style="background-color:#01515a; color:#ffffff">#01515a</td>
    </tr>
    <tr>
      <td style="background-color:#008037; color:#008037">#008037</td>
      <td style="background-color:#50a0a0; color:#50a0a0">#50a0a0</td>
      <td style="background-color:#f1c40f; color:#f1c40f">#f1c40f</td>
      <td style="background-color:#005151; color:#005151">#005151</td>
      <td style="background-color: #9eff62; color: #9eff62"> #9eff62</td>
    </tr>
  </tbody>
</table>



## Telas
<span style="color:red;">![AVISO]</span> As telas ainda estão em andamento e nem todas constam neste documento. :warning:

####  Login
  Em que o funcionário insere seus dados(Nome e senha), para assim acessar o software.
Caso digite informações inválidas, o sistema avisará o usuário para que assim o corrija.
  ![imagem](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaInicial1.png)

> Mensagem de aviso gerada pela validação de acesso:
  ![imagem](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaInicial2.png)
  ![imagem](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaInicial3.png)

#### Início
É a tela padrão do software em que o funcionário é capaz de realizar suas funções,com cada botão abrindo telas novas com suas respectivas propriedades.

![image](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaPadrao.png)


#### Marcar Consulta
Nesta tela é possível marcar uma consulta preenchendo os campos pendentes e selecionando o paciente e o médico que irá atender, assim como formas de pagamento e a data da consulta.
 
 ![image](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaMarcarConsulta.png)

#### Consultas Pendentes
Exibe as consultas que foram marcadas, onde é exibido o setor do profissional, nome do profissional, além da data prevista. A opção de controle de consultas pendentes 

 ![image](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaConsultaPendentes.png)


#### Cadastrar Paciente
  Insere as informações dos pacientes, as registrando no sistema.
  
![image](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaCadastroPaciente.png)


#### Lista pacientes
Exibe todos os pacientes já registrados, caso clique em determinado paciente, revelará suas informações gerais.

![image](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaListaPaciente.png)

#### Ficha paciente
Nesta tela as informações já registradas no sistema do paciente serão exibidas permitindo apenas alteração de campos que poderão mudar com o tempo.

![image](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaFichaPacientes.png)


#### Tela cadastrar profissional
Nesta tela, o usuário (adm) poderá registrar um profissional no sistema, sendo ele: médico, secretário, administrador, outro.

![image](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaCadastrarProfissional-Medico.png)


#### Tela alterar profissional
Nesta tela, é possível alterar informações já registradas do profissional.

![image](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaAlterarProfissional.png)

#### Tela Lista Profissional
Nesta tela a lista dos profissionais cadastrados no sistema é evidenciada, contendo um campo de texto para pesquisa por nome. A visão controle de administrador aparece apenas na visão do adm.

![image](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaListaProfissionais.png)


#### Tela Anamnese
A tela Anamnese é visível apenas para o médico, visto que, a anamnese ocorre durante a consulta. Nela é exibida informação já cadastrada do paciente e informações a serem preenchidas pelo médico durante a realização da consulta.

![image](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaAnamnese.png)

#### Tela Histórico:
Exibe informações de consultas já finalizadas de um determinado paciente.

![image](https://github.com/stwchaos/curatio/blob/main/imgMD/TelaHistorico.png)
