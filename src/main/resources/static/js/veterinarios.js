// Call the dataTables jQuery plugin
$(document).ready(function() {
    cagarVeterinarios();
    $('#veterinario').DataTable();
});

async function cagarVeterinarios() {

    const request = await fetch('api/veterinarians', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const veterinarios = await request.json();
    //console.log(veterinarios[0].veterinarianSpeciality.name);


    let listadoHtml = '';

    for (let veterinario of veterinarios) {
        let getButton =
            '<a href="#" onclick="getRecord(' +
            veterinario.id +
            ')" class="btn btn-primary btn-circle btn-sm"><i class="fas fa-eye"></i></a>';

        let updateButton = '<a href="#" onclick="updateRecord(' + veterinario.id +
            ')" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-pencil"></i></a>';

        let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + veterinario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        console.log("lo que obtienes: "+veterinarios[0].veterinarianSpeciality.name)

        let veterinarioHtml =`<tr><td>${veterinario.id}</td><td> ${veterinarios[0].veterinarianSpeciality.name}  </td><td>
            ${veterinario.fullname}</td><td> ${getButton}  ${updateButton} ${botonEliminar}</td></tr>` ;
        listadoHtml += veterinarioHtml;
    }

    document.querySelector("#veterinario tbody").outerHTML=listadoHtml;

}


async function eliminarUsuario(id){

    if(!confirm(`¿Desea eliminar este usuario`)){
        return;
    }

    function getHeaders() {
        return {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.token
        };
    }


    const request = await fetch('api/usuarios/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });
    location.reload();
}