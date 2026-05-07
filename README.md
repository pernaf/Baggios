<div align="center">

# 🎸 The Baggios App

**Press kit e materiais da banda na palma da mão.**

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Material3](https://img.shields.io/badge/Material_3-757575?style=for-the-badge&logo=material-design&logoColor=white)

</div>

---


## 📱 Sobre o App

Aplicativo Android desenvolvido em **Jetpack Compose** para centralizar todos os materiais oficiais da banda **The Baggios** — desde o press release até o rider técnico, tudo acessível de forma rápida e elegante.

> The Baggios é uma banda sergipana fundada em 2004, com 2 indicações ao Grammy Latino e mais de 20 anos de carreira.

---

## 📸 Screenshots

| Home | Discografia | Rider Técnico |
|:---:|:---:|:---:|
| ![Home]<img width="702" height="1600" alt="tela principal" src="https://github.com/user-attachments/assets/b0047ee0-24a0-4ade-979b-1137a5c8bd0e" /> | ![Discografia]<img width="702" height="1600" alt="tela discografia" src="https://github.com/user-attachments/assets/66eb3173-bba4-4376-85ec-4735618c592e" /> | ![Rider]<img width="702" height="1600" alt="tela rider" src="https://github.com/user-attachments/assets/1cef80b0-7ea2-4f50-bf73-499ea7f59207" />
 |




## ✨ Funcionalidades

| Tela | Descrição |
|---|---|
| 📄 **Release** | Bio completa da banda com card de destaque para as indicações ao Grammy Latino |
| 💿 **Discografia** | 5 álbuns, 4 EPs e 1 DVD ao vivo com capas reais e link direto para o Spotify |
| 🎤 **Agenda de Shows** | Próximas datas com local, cidade e detalhes do evento |
| 🎛 **Rider Técnico** | PDFs do rider e mapas de palco disponíveis para visualizar e compartilhar |
| 🖼 **Fotos** | Galeria de press photos e fotos de shows com visualização fullscreen |
| 📞 **Contatos** | Email e telefone clicáveis para booking e assessoria |
| 🔗 **Redes Sociais** | Links diretos para Instagram, Spotify, YouTube, Facebook, Twitter e Deezer |

---

## 🎨 Design

O tema visual foi desenvolvido com base na identidade do press kit oficial da banda:

- **Fundo:** Azul noite profundo `#0D1B2E`
- **Destaque:** Ciano vibrante `#00B4D8`
- **Estilo:** Dark, imersivo, rock com raízes nordestinas
- **Tipografia:** Clean com espaçamento generoso

---

## 🛠 Tecnologias

- **[Jetpack Compose](https://developer.android.com/jetpack/compose)** — UI declarativa
- **[Navigation Compose](https://developer.android.com/jetpack/compose/navigation)** — Navegação entre telas
- **[Coil](https://coil-kt.github.io/coil/)** — Carregamento de imagens
- **[Material 3](https://m3.material.io/)** — Design system
- **[Room](https://developer.android.com/training/data-storage/room)** — Banco de dados local
- **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)** — Gerenciamento de estado
- **[FileProvider](https://developer.android.com/reference/androidx/core/content/FileProvider)** — Compartilhamento de PDFs

---

## 📁 Estrutura do Projeto

```
com.example.baggios/
│
├── ui/
│   ├── theme/
│   │   ├── Color.kt
│   │   ├── Type.kt
│   │   └── Theme.kt
│   ├── navigation/
│   │   ├── Screen.kt
│   │   └── NavGraph.kt
│   └── screens/
│       ├── home/
│       ├── release/
│       ├── discography/
│       ├── shows/
│       ├── rider/
│       ├── photos/
│       ├── contacts/
│       └── social/
│
└── MainActivity.kt
```

---

## 🚀 Como rodar o projeto

### Pré-requisitos

- Android Studio Hedgehog ou superior
- JDK 11+
- Android SDK 24+

### Passos

```bash
# Clone o repositório
git clone https://github.com/seuusuario/baggios-app.git

# Abra no Android Studio
# File → Open → selecione a pasta do projeto

# Sincronize o Gradle
# Clique em "Sync Now" quando solicitado

# Rode o app
# Shift + F10 ou clique em Run ▶
```

---

## 📦 Dependências principais

```kotlin
// Navegação
implementation("androidx.navigation:navigation-compose:2.7.7")

// Banco de dados local
implementation("androidx.room:room-runtime:2.6.1")
implementation("androidx.room:room-ktx:2.6.1")

// Carregamento de imagens
implementation("io.coil-kt:coil-compose:2.6.0")

// ViewModel
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

// Ícones extras
implementation("androidx.compose.material:material-icons-extended:1.6.4")

// PDF Viewer
implementation("io.github.afreakyelf:Pdf-Viewer:2.1.1")
```

---

## 🎵 Sobre a Banda

**The Baggios** foi criada em 2004 na cidade de São Cristóvão, Sergipe, pelo guitarrista Julio Andrade, hoje acompanhado por Gabriel Perninha (bateria) e Rafael Ramos (teclado).

Com mais de 20 anos de carreira, a banda acumula:

- 🏆 2x indicada ao **Grammy Latino** (2017 e 2019)
- 🎪 Apresentação no **Lollapalooza 2016**
- 🌍 Turnês pelos **EUA, Canadá, México, Itália, França, Suíça e Inglaterra**
- 💿 **5 álbuns**, **4 EPs** e **1 DVD ao vivo**

---

## 📬 Contato

| | |
|---|---|
| 📧 Email | thebaggios@gmail.com |
| 📱 Telefone | +55 79 98809-0974 |
| 🎵 Spotify | [The Baggios](https://open.spotify.com/intl-pt/artist/1EYPUMAsFA0qjFmnADnBJ5) |
| 📸 Instagram | [@thebaggios](https://instagram.com/thebaggios) |
| ▶ YouTube | [/thebaggios](https://youtube.com/thebaggios) |

---
## License
```
The MIT License (MIT)

Copyright (c) 2026 Gabriel de Oliveira Carvalho

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

