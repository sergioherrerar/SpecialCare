// Call the dataTables jQuery plugin
$(document).ready(function() {
  cagarUsuarios();
  $('#usuarios').DataTable();
});

async function cagarUsuarios() {

  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': localStorage.token
    }
  });
  const usuarios = await request.json();
  let listadoHtml = '';


  for (let usuario of usuarios) {

    let phone_Number_text = usuario.phone_Number == null ? '-' : usuario.phone_Number;
    let lastname_text = usuario.lastname == null ? '-' : usuario.lastname;

    let botonEliminar = `<a href="#" onclick="eliminarUsuario(${usuario.id})" class="btn btn-danger btclassNamecle btn-sm"><i class="fas fa-trash"></iclassName </a>`;
    let usuarioHtml = `<tr><td>${usuario.id}</td><td>${usuario.name + " " + lastname_text }</td>
                       <td>${usuario.email}</td><td>${usuario.password}</td><td>${phone_Number_text}</td>
                       <td>${botonEliminar}</td></tr>`

    listadoHtml += usuarioHtml
  }

 //console.log(usuarios);


 document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

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