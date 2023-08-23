// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadSpecialities()

});

/*
async function obtenerEspecialidad() {
        // Hacer la solicitud usando Fetch
        const response = await fetch('api/veterinarian-specialities');

        // Verificar si la respuesta es exitosa
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        // Convertir la respuesta a JSON
        const data = await response.json();

        // Obtener el elemento combo
        const combo = document.getElementById('miCombo');

        // Llenar el combo con las especialidades obtenidas
        data.forEach(item => {
            console.log(data)
            const opcion = document.createElement('option');
            opcion.value = item.id;
            opcion.textContent = item.name;
            combo.appendChild(opcion);
        });
}

*/

async function loadSpecialities() {
    const request = await fetch("api/veterinarian-specialities", {
        method: "GET",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
    });

    const specialities = await request.json();

    var html = "";
    for (var specialitie of specialities) {
        var rowHtml = `<option value="${specialitie.id}">${specialitie.id} - ${specialitie.name}</option>`;
        html += rowHtml;
    }

    document.querySelector("#txtSpecialitie").innerHTML = html;
}

/*
async function registrarVeterinario() {
    let datos = {};
    datos.name = document.getElementById('txtName').value;
    datos.veterinarianSpecialityId = document.getElementById('miCombo').value;

    const requestV = await fetch('api/veterinarians', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

}
*/
async function register() {
    let data = {};
    data.petId = document.getElementById("txtName").value;
    data.veterinarianId = document.getElementById("txtSpecialitie").value;


    await fetch("api/veterinarians", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });

    alert("¡El registro fue creado con éxito!");

    window.location.href = "history-diseases.html";
}










