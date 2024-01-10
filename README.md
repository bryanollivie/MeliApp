MeliApp - 1.0
============================================================================

## Visão Geral
Este repositório contém um projeto Android, desenvolvido com as mais recentes tecnologias e melhores práticas da indústria. 
O projeto demonstra praticas em desenvolvimento Android, incluindo o uso eficiente de padrões de design, integração de APIs modernas e implementação de uma UX/UI intuitiva e responsiva. 

Introdução
------------

Este projeto Android utiliza várias tecnologias e bibliotecas modernas para garantir a eficiência, modularidade e performance. Abaixo estão algumas das principais tecnologias utilizadas:

- Kotlin: Linguagem de programação principal.
- MVVM: Padrão de arquitetura para uma organização de código clara e separação de responsabilidades.
- Hilt: Para injeção de dependência, facilitando a manutenção e testabilidade.
- Jetpack Navigation: Simplifica a implementação da navegação em aplicativos Android.
- LeakCanary: Para detecção de vazamentos de memória.
- Retrofit: Para chamadas de rede, oferecendo uma maneira eficiente de se conectar com APIs REST.
- Room: Para persistência de dados, permitindo um fácil acesso a bancos de dados locais e cache.
- Coroutines/Flow: Para programação assíncrona, melhorando a performance e a legibilidade do código.
- JUnit/Mockito: Para testes unitários, assegurando a qualidade e robustez do código.


![meli3](https://github.com/bryanollivie/MeliApp/assets/3091271/b3e11789-511e-4400-bdd4-e660913512ef)

Arquitetura Macro
------------

![Screen Recording 2024-01-10 at 18 55 20](https://github.com/bryanollivie/MeliApp/assets/3091271/a3aa4a8f-40ed-42d2-bf78-c1a1d1d75260)


Características Principais
- MVVM: Arquitetura que separa a lógica de negócios da interface do usuário, facilitando a manutenção e os testes.
- ==> Model: Representa os dados e a lógica de negócios. Pode incluir o banco de dados, rede ou qualquer outra fonte de dados.
- ==> View: É a camada de interface do usuário, geralmente activity ou fragments,que exibe os dados e envia interações.
- ==>ViewModel: Atua como um intermediário entre o Model e a View, contendo a lógica de apresentação. Ele observa mudanças no Model e atualiza a View.
- Android Application: Utilizamos uma classe Application personalizada para inicializar componentes globais.
- Repositório Local: Gerencia os dados armazenados localmente, por exemplo, usando o Room para persistência de dados.
- Repositório Remoto: Lida com a comunicação de rede, como chamadas API, utilizando Retrofit.
