async function register() {
    let data = {};
    data.firstName = document.getElementById('txtFirstName').value;
    data.secondName = document.getElementById('txtSecondName').value;
    data.lastname = document.getElementById('txtLastname').value;

    data.secondLastname = document.getElementById('txtSecondLastname').value;
    data.email = document.getElementById('txtEmail').value;
    data.password = document.getElementById('txtPassword').value;

    let repeatPassword  = document.getElementById('txtRepeatPassword').value;

    if(repeatPassword != data.password){
        alert(`Las contraseñas digitadas no son coincidentes`)
        return;

    }

    await fetch('api/users', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    alert("¡La cuenta fue creada con éxito!");

    window.location.href="login.html"
}

