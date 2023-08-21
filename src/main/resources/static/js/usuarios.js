// Call the dataTables jQuery plugin
$(document).ready(function() {
    cagarUsuarios();
  $('#usuarios').DataTable();
});

async function cagarUsuarios() {

  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  const usuarios = await request.json();

   let listadoHtml = '';
    for (let usuario of usuarios) {
      let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

      let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>' + usuario.name + ' ' + usuario.lastname + '</td><td>'
                      + usuario.email+'</td><td>'+usuario.phone_Number
                      + '</td><td>' + botonEliminar + '</td></tr>';
      listadoHtml += usuarioHtml;
    }

document.querySelector("#usuarios tbody").outerHTML=listadoHtml;

}