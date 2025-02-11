document.getElementById("btnCriptografar").addEventListener("click", async () => {
    const texto = document.getElementById("texto").value;

    if (!texto) {
        document.getElementById("resultado").value = "O texto não pode ser vazio.";
        return;
    }

    const response = await fetch(`/api/criptografar`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: new URLSearchParams({ texto })
    });

    if (!response.ok) {
        const erro = await response.text();
        document.getElementById("resultado").value = erro;
    } else {
        const resultado = await response.text();
        document.getElementById("resultado").value = resultado;
    }
});

document.getElementById("btnDescriptografar").addEventListener("click", async () => {
    const texto = document.getElementById("texto").value;

    if (!texto) {
        document.getElementById("resultado").value = "O texto criptografado não pode ser vazio.";
        return;
    }

    const response = await fetch(`/api/descriptografar`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: new URLSearchParams({ textoCriptografado: texto }) // Envia corretamente o texto criptografado
    });

    if (!response.ok) {
        const erro = await response.text();
        document.getElementById("resultado").value = erro;
    } else {
        const resultado = await response.text();
        document.getElementById("resultado").value = resultado;
    }
});

document.getElementById("btnTema").addEventListener("click", () => {
    const body = document.body;
    const themeIcon = document.getElementById("iconTheme");

    // Alterna o tema entre "light" e "dark"
    if (body.dataset.theme === "dark") {
        body.dataset.theme = "light";
        themeIcon.textContent = "🌞";  // Sol
    } else {
        body.dataset.theme = "dark";
        themeIcon.textContent = "🌙";  // Lua
    }
});