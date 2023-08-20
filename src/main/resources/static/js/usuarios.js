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
  let listadoHtml = ''
  for (let usuario of usuarios) {


    let usuarioHtml = `<tr><td>${usuario.id}</td><td>${usuario.name + " " + usuario.lastname}</td>
                       <td>${usuario.email}</td><td>${usuario.password}</td><td>${usuario.phone_Number}</td>
                       <td><a href="#" class="btn btn-danger btclassNamecle btn-sm"><i class="fas fa-trash"></iclassName </a></td></tr>`

    listadoHtml += usuarioHtml
  }

 //console.log(usuarios);


 document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}