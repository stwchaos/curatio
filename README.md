
<h1 align="center"> Projeto Integrador - Curatio  </h1>


---
### Progresso do projeto
▓▓▓▓▓▓▓▓▓▓▓ 100%



---

## Introdução
O Projeto Integrador que estamos desenvolvendo na linguagem Java tem como objetivo criar o Curatio, um software específico para hospitais, visando aprimorar o controle de pacientes e consultas pelos profissionais da área de saúde. Esse projeto está sendo desenvolvido para a disciplina de Projeto Integrador no Instituto Federal de Santa Catarina.

O Curatio é um sistema administrativo desenvolvido para atender às necessidades de instituições de saúde modernas. Ele oferece benefícios como administração eficaz e melhor atendimento aos pacientes, por meio da automação e integração tecnológica. O objetivo principal do projeto é facilitar a administração e controle dos funcionários, proporcionando uma gestão mais eficiente e promovendo melhorias no ambiente de trabalho.

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



## Telas e Funcionalidades


####  Login
No momento em que o funcionário insere seus dados (nome e senha), é possível acessar o software. Se forem inseridas informações inválidas, o sistema irá notificar o usuário para que possa corrigi-las.

  ![imagem](https://github.com/stwchaos/curatio/blob/main/imgMD/Login.gif)
  

#### Funcionários gerais
O Administrador do sistema poderá gerenciar o cadastro dos funcionários gerais

 ![imagem](https://github.com/stwchaos/curatio/blob/main/imgMD/Profissionais.gif)
 ---
 ![imagem](https://github.com/stwchaos/curatio/blob/main/imgMD/SecretarAdm.gif)


#### Paciente
Na seção "Pacientes", é possível inserir as informações dos pacientes, registrando-os no sistema. Também é exibida uma lista de todos os pacientes já registrados. Ao clicar em um paciente específico, suas informações gerais são reveladas e é possível realizar alterações.
 
![image](https://github.com/stwchaos/curatio/blob/main/imgMD/CadastroPaciente.gif)
---
![image](https://github.com/stwchaos/curatio/blob/main/imgMD/Pacientes.gif)


#### Consulta
É possível marcar uma consulta selecionando o paciente por meio da tela "Marcar Consulta" ou selecionando diretamente o paciente na tela "Pacientes" para agendar o atendimento. As consultas não comparecidas (quando o paciente não comparece sem aviso prévio) serão destacadas em vermelho na JTable.
 
 ![image](https://github.com/stwchaos/curatio/blob/main/imgMD/Consulta(1).gif)


#### Anamnese
A tela Anamnese é visível apenas para o médico, visto que, a anamnese ocorre durante a consulta. Nela é exibida informação já cadastrada do paciente e informações a serem preenchidas pelo médico durante a realização da consulta. Assim que uma consulta for realizada, ela será transferida para a tela Histórico de consultas presente em cada paciente, nela, será possível visualizar a anamnese daquele consulta anterior. Apenas médicos terão acesso a esta função.

![image](https://github.com/stwchaos/curatio/blob/main/imgMD/AnamneseLogout.gif)


## Referências Bibliográficas

<p=align: "center">
  <img src="https://github.com/stwchaos/curatio/blob/main/imgMD/ref.png" alt="logo" width="200" height="100">
</p>

¹ ANDRADE, Davi Gomes de; FALK, James Anthony. Eficácia de sistemas de informação e percepção de mudança organizacional: um estudo de caso. Revista de administração contemporânea, v. 5, p. 53-84, 2001.

---

## Considerações finais
![image](https://github.com/stwchaos/curatio/blob/main/imgMD/ConslusoesFinais.png)

