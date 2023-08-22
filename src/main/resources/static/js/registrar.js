// Call the dataTables jQuery plugin
$(document).ready(function() {


});

async function registrarUsuario() {
    let datos = {};
    datos.name = document.getElementById('txtName').value;
    datos.lastname = document.getElementById('txtLastName').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    let repetirPasswrod  = document.getElementById('txtRepeatPassword').value;


    if(repetirPasswrod != datos.password){
        alert(`La contraseña que escribiste es diferente`)
        return;

    }
    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    alert("¡La cuenta fue creada con éxito!");
    window.location.href="login.html"
}

